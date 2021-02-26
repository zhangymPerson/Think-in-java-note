package router

import (
	"gogin/controller"
	"net/http"

	"github.com/gin-gonic/gin"
)

//InitRouter 初始化请求路由
// 分配路由到各个实现函数中
func InitRouter(router *gin.Engine) {
	router.GET("/get", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "request success",
		})
	})
	router.GET("/get/one", controller.One)
	router.POST("/post/error", controller.PostError)
	router.POST("/post", controller.Post)
	router.POST("/msg", controller.Msg)
	//带参数 路径中的参数 data中的参数
	router.POST("/post/params", controller.PostParams)

	// 这个handler 将会匹配 /user/john 但不会匹配 /user/ 或者 /user
	router.GET("/user/:name", func(c *gin.Context) {
		name := c.Param("name")
		c.String(http.StatusOK, "Hello %s", name)
	})

	// 但是, 这个将匹配 /user/john/ 以及 /user/john/send
	// 如果没有其他路由器匹配 /user/john, 它将重定向到 /user/john/
	router.GET("/user/:name/*action", func(c *gin.Context) {
		name := c.Param("name")
		action := c.Param("action")
		message := name + " is " + action
		c.String(http.StatusOK, message)
		c.JSON(http.StatusOK, "路由1")
	})

	// 对于每个匹配的请求，上下文将保留路由定义
	router.POST("/user/:name/*action", func(c *gin.Context) {
		// true
		//c.FullPath() == "/user/:name/*action"
		c.JSON(http.StatusOK, "路由2")
	})

}
