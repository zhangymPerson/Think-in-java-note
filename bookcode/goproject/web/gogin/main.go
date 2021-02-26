package main

import (
	"fmt"
	"gogin/router"
	"io"
	"os"

	"github.com/gin-gonic/gin"
)

func main() {
	fmt.Printf("ginweb项目测试\n")
	r := gin.Default()
	// Logging to a file.
	f, _ := os.Create("gin.log")
	gin.DefaultWriter = io.MultiWriter(f)

	// 如果需要同时将日志写入文件和控制台，请使用以下代码。
	gin.DefaultWriter = io.MultiWriter(f, os.Stdout)
	router.InitRouter(r)
	//默认端口是 8080
	r.Run(":8088")
}
