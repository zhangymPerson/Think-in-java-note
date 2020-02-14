package code

import (
	"fmt"
)

//函数名首字母大写 则外部包可以调用 否则只能内部调用
func LoopOne() {
	fmt.Println("循环方式1")
	for {
		fmt.Print("无限循环")
	}
}

//循环的第二种写法
func LoopTwo(i int) {
	for j := 0; j < i; j++ {
		fmt.Println(j, "<", i)
	}
}

//私有函数
func privateFunc() string {
	return "调用私有函数成功"
}

//公有函数
func PublicFunc() string {
	return "调用公有函数成功"
}
