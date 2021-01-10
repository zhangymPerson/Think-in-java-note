package controller

import (
	"goweb/result"
	"io"
	"net/http"
)

//自定义controller类
func GetInfo(w http.ResponseWriter, r *http.Request) {
	res := result.GetSuccessResult("Get请求成功")
	io.WriteString(w, res.ToJson())
}

//post请求返回模拟
func PostInfo(w http.ResponseWriter, r *http.Request) {
	res := result.GetSuccessResult("Post 请求成功")
	errRes := result.GetSuccessResult("非Post请求")
	//判断是否是post请求
	if r.Method != "POST" {
		io.WriteString(w, errRes.ToJson())
	} else {
		io.WriteString(w, res.ToJson())
	}
}
