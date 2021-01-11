package routes

import (
	"goweb/controller"
	"io"
	"net/http"
)

func Hi(w http.ResponseWriter, r *http.Request) {
	io.WriteString(w, "Hi,goweb")
}

func Route() {
	//原生网络开发
	http.HandleFunc("/hellos", func(w http.ResponseWriter, r *http.Request) {
		w.Write([]byte("hello world!"))
	})
	//HandlerFunc 和 HandleFunc 不一样，一个是 自定义函数类型 一个是 函数
	http.HandleFunc("/hello", func(w http.ResponseWriter, r *http.Request) {
		io.WriteString(w, "Hello Word")
	})
	//调用自定义的函数
	http.HandleFunc("/hi", Hi)

	//自定义返回
	http.HandleFunc("/get", controller.GetInfo)

	http.HandleFunc("/user", controller.GetUserFromId)

	//post请求方式
	http.HandleFunc("/post", controller.PostInfo)
}
