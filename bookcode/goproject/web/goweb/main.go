package main

import (
	"fmt"
	"goweb/routes"
	"log"
	"net/http"
)

func main() {
	fmt.Println("hello goweb")
	//路由配置提取出去
	routes.Route()
	//注意事项：
	//端口前面需要加 : 否则报错 listen tcp: address 8080: missing port in address
	err := http.ListenAndServe(":8080", nil)
	if err != nil {
		log.Fatal("服务异常", err.Error())
	}
}
