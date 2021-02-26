package controller

import (
	"fmt"
	"gogin/bean"
	"net/http"

	"github.com/gin-gonic/gin"
)

// PostError 测试错误返回
func PostError(c *gin.Context) {
	var result bean.ResultCodeError
	result.Str = "string"
	result.Data = map[string]string{"username": "username", "password": "password"}
	fmt.Printf("result对象是：%v\n", result)
	c.JSON(200, result)
}

// Post 测试错误返回
func Post(c *gin.Context) {
	var result bean.ResultCode
	result.Status = http.StatusOK
	result.Msg = "success"
	result.Data = map[string]string{"username": "username", "password": "password"}
	c.JSON(http.StatusOK, result)
}

// Msg 普通请求测试
func Msg(c *gin.Context) {
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

//PostParams 测试传参 name=name&message=message
// curl -X POST 'http://127.0.0.1:8088/post/params?id=1&name=abc' --header 'Content-Type: application/x-www-form-urlencoded' --data 'name=name&message=message'
func PostParams(c *gin.Context) {
	//Query 获取路径中的值 
	id := c.Query("id")
	page := c.DefaultQuery("page", "0")
	//PostForm 获取data中的值
	name := c.PostForm("name")
	message := c.PostForm("message")
	fmt.Printf("id: %s; page: %s; name: %s; message: %s\n", id, page, name, message)
	c.JSON(http.StatusOK, "success")
}
