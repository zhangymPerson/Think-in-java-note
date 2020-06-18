package result

import (
	"io"
	"net/http"
)

//自定义controller类
func GetInfo(w http.ResponseWriter, r *http.Request) {
	result := Result{
		Code:   200,
		Msg:    "success",
		Result: "Get请求成功",
	}
	io.WriteString(w, result.ToJson())
}
