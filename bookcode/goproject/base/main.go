package main

import (
	"base/code"
	"fmt"
)

//go文件在同一个包中 可以直接互相调用
//主程序
func main() {
	fmt.Println("hello word")
	//调用同一个包中的函数 可以直接调用 可以调用私有函数
	i := method(1, 2)
	fmt.Println(i)
	//调用别的包中的函数 需要先 import 相关包 且只能调用公有函数
	str := code.PublicFunc()
	fmt.Println(str)
	code.LoopTwo(10)
	code.ChooseOne()
	code.VarTest()
	code.FunTest()
	var co code.ClassObj
	co.Width = 1.0
	co.Height = 2.0
	co.Area()
	fmt.Println("end")
	code.TestArrAndSliceOne()
	code.TestArrAndSliceTwo()
}
