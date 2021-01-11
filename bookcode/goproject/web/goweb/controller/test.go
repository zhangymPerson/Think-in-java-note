package controller

import (
	"goweb/bean"
	"io"
	"net/http"
)

//自定义controller类
func GetInfo(w http.ResponseWriter, r *http.Request) {
	res := bean.GetSuccessResult("Get请求成功")
	io.WriteString(w, res.ToJson())
}

//post请求返回模拟
func PostInfo(w http.ResponseWriter, r *http.Request) {
	res := bean.GetSuccessResult("Post 请求成功")
	errRes := bean.GetSuccessResult("非Post请求")
	//判断是否是post请求
	if r.Method != "POST" {
		io.WriteString(w, errRes.ToJson())
	} else {
		io.WriteString(w, res.ToJson())
	}
}
