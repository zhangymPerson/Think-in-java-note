package main

import (
	"github.com/kataras/iris"
	"log"
)

func main() {
	app := iris.New()
	//
	app.Handle("GET", "/contact", func(ctx iris.Context) {
		//测试输出html
		ctx.HTML("<h1> Hello from /contact </h1>")
	})
	//http://localhost:8080/getParam?key=124
	app.Get("/getParam", func(context iris.Context) {
		//获取参数
		app.Logger().Infof("GET-请求路由[%v],请求内容key = [%v]", context.Path(), context.URLParam("key"))
		context.Text("request Success!")
	})
	//
	app.Post("/getParam", func(context iris.Context) {
		app.Logger().Infof("POST-请求路由[%v],请求内容key = [%v]", context.Path(), context.URLParam("key"))
		context.Text("request Success!")
	})
	//
	app.Handle("GET", "/test", func(context iris.Context) {
		context.Text("测试iris框架中文")
		context.Text("测试输出文本2")
		app.Logger().Infof("获取路由[%v]", context.Path())
	})

	//===============================================================
	//测试路由中携带参数
	//请在参数化路径部分
	//http://localhost:8080/users/a 报错 Not Found
	//创建路由组 并且存在的路由都要先通过 myAuthMiddlewareHandler 函数
	users := app.Party("/users", myAuthMiddlewareHandler)
	// http://localhost:8080/users/42/profile
	users.Get("/{id:int}/profile", userProfileHandler)
	// http://localhost:8080/users/inbox/1
	users.Get("/inbox/{id:int}", userMessageHandler)
	app.Run(iris.Addr(":8080"))
}

func myAuthMiddlewareHandler(ctx iris.Context) {
	log.Printf("myAuthMiddlewareHandler = 请求路由[%v]", ctx.Path())
	ctx.WriteString("组路由处理函数\nAuthentication failed\n")
	//调用则走子路由，否则不走
	ctx.Next()
}
func userProfileHandler(ctx iris.Context) { //
	log.Printf("userProfileHandler = 请求路由[%v]", ctx.Path())
	//获取参数
	id := ctx.Params().Get("id")
	ctx.WriteString(id)
}
func userMessageHandler(ctx iris.Context) {
	log.Printf("userMessageHandler = 请求路由[%v]", ctx.Path())
	id := ctx.Params().Get("id")
	ctx.WriteString(id)
}
