package controller

import (
	"log"

	"github.com/gin-gonic/gin"
)

//One is test get request
func One(c *gin.Context) {
	log.Printf("Get请求成功,请求参数 %v \n", c)
	c.JSON(200, gin.H{
		"message": "request success",
	})
}
