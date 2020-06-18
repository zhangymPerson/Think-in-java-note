package main

import (
	"fmt"
	"goweb/result"
	"io"
	"log"
	"net/http"
)

func Hi(w http.ResponseWriter, r *http.Request) {
	io.WriteString(w, "Hi,goweb")
}

func main() {
	fmt.Println("hello goweb")
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
	http.HandleFunc("/get", result.GetInfo)

	//注意事项：
	//端口前面需要加 : 否则报错 listen tcp: address 8080: missing port in address
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("服务异常", err.Error())
	}
}
