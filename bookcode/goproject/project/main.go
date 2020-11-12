package main

import (
	"fmt"
	"project/argutil"
	"project/function"
	//go mod init project
	//创建好项目后，创建自定义包，如果要引入自定义包，则需要从项目名开始引入
	//即 project/model
	//而不是 ./model 或者 model/ 都是错误的
	"project/model"
)

func main() {
	fmt.Print("test")
	node := model.TreeNode{}
	//node.Print()
	//fmt.Println()
	node.Print()
	fmt.Println()
	node1 := model.TreeNode{
		Value: 3,
		Left:  &node,
	}
	//方法的调用 省略取地址符 &
	node1.Print()
	//如果是指针，不能省略却地址符号
	model.Prints(&node1)
	fmt.Println()
	function.FuncUse()
	//调用命令行测试
	argutil.Args()
	p := model.Person{
		Name : "zhangsan",
		Age:23,
	}
	var name string = p.GetName()
	fmt.Println(name)

}
