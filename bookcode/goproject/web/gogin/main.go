package main

import (
	"fmt"
	"net/http"

	"github.com/gin-gonic/gin"
)

//错误的返回对象无法返回 json无法解析 字段名小写的对象
type ResultCodeError struct {
	str  string
	data interface{} `json:"data"`
}

//构建返回对象
type ResultCode struct {
	//json注释必须 `json:"key"` 中间不能有任何空格
	Status int         `json:"status"`
	Msg    string      `json:"msg"`
	Data   interface{} `json:"data"`
}

func main() {
	fmt.Printf("ginweb项目测试\n")
	r := gin.Default()
	r.GET("/get", func(c *gin.Context) {
		c.JSON(200, gin.H{
			"message": "request success",
		})
	})
	r.POST("/post/error", postError)
	r.POST("/post", post)
	r.POST("/msg", msg)
	//默认端口是 8080
	r.Run(":8088")
}

func postError(c *gin.Context) {
	var result ResultCodeError
	result.str = "string"
	result.data = map[string]string{"username": "username", "password": "password"}
	fmt.Printf("result对象是：%v\n", result)
	c.JSON(200, result)
}

func post(c *gin.Context) {
	var result ResultCode
	result.Status = http.StatusOK
	result.Msg = "success"
	result.Data = map[string]string{"username": "username", "password": "password"}
	c.JSON(http.StatusOK, result)
}

func msg(c *gin.Context) {
	var msg struct {
		Name    string `json:"user"`
		Message string
		Number  int
	}
	msg.Name = "Lena"
	msg.Message = "hey"
	msg.Number = 123
	// 注意 msg.Name 在 JSON 中会变成 "user"
	// 将会输出： {"user": "Lena", "Message": "hey", "Number": 123}
	c.JSON(http.StatusOK, msg)
}
