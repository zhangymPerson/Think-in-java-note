package bean

import (
	"encoding/json"
	"log"
)

//Result 统一错误返回格式
type Result struct {
	Code   int         `json:"code"`
	Msg    string      `json:"msg"`
	Result interface{} `json:"result"`
}

//ToJson 错误返回json字符串
func (r *Result) ToJson() string {
	if r != nil {
		json, err := json.Marshal(r)
		if err != nil {
			log.Fatal("r对象转json异常", err.Error())
		}
		return string(json)
	} else {
		errR := Result{
			Code:   500,
			Msg:    "r不能为null",
			Result: "fail",
		}
		json, err := json.Marshal(errR)
		if err != nil {
			log.Fatal("errR转json异常", err.Error())
			return "r is null and error not change json"
		}
		return string(json)
	}
}

func GetSuccessResult(data interface{}) Result {
	return Result{
		Code:   200,
		Msg:    "success",
		Result: data,
	}
}