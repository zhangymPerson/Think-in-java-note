package argutil

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
)

func GetJsonFile(file string) {
	byte, err := ioutil.ReadFile(file)
	if err != nil {
		fmt.Errorf("读取%v异常,异常信息:%v", file, err)
	}
	conf := make(map[string]interface{})
	json.Unmarshal(byte, &conf)
	fmt.Print(conf)
}
