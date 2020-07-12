package result

import (
	"io"
	"net/http"
)

func GetSuccessResult(data interface{}) Result {
	return Result{
		Code:   200,
		Msg:    "success",
		Result: data,
	}
}

//自定义controller类
func GetInfo(w http.ResponseWriter, r *http.Request) {
	result := GetSuccessResult("Get请求成功")
	io.WriteString(w, result.ToJson())
}

//post请求返回模拟
func PostInfo(w http.ResponseWriter, r *http.Request) {
	result := GetSuccessResult("Post 请求成功")
	errRes := GetSuccessResult("非Post请求")
	//判断是否是post请求
	if r.Method != "POST" {
		io.WriteString(w, errRes.ToJson())
	} else {
		io.WriteString(w, result.ToJson())
	}
}
