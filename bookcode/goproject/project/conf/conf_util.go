package conf

import (
	"encoding/json"
	"io/ioutil"
	"log"
)

//定义json接收类型
type JsonValue map[string]interface{}

func GetConfValue(confPath string) JsonValue {
	var jsonValue JsonValue
	//读取配置文件
	value, err := ioutil.ReadFile(confPath)
	if err != nil {
		panic(err)
	}
	//转json到接收类型上
	errors := json.Unmarshal(value, &jsonValue)
	if errors != nil {
		panic(errors)
	}
	log.Println(jsonValue)
	return jsonValue
}
