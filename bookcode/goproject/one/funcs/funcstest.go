package funcs

import "fmt"

//私有函数
func privateFunc() string {
	fmt.Print("调用私有函数")
	return "私有函数"
}
//公有函数
func PublicFunc() string {
	fmt.Print("调用公有函数")
	return "公有函数"
}