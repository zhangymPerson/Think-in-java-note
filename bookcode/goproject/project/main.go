package main

import (
	//go mod init project 
	//创建好项目后，创建自定义包，如果要引入自定义包，则需要从项目名开始引入 
	//即 project/model  
	//而不是 ./model 或者 model/ 都是错误的
	"project/model"
	"project/function"
	"fmt"
)

func main()  {
	fmt.Print("test")
	node:=	model.TreeNode{}
	node.Print()
	fmt.Println()
	node1:=model.TreeNode{
		Value:3,
		Left:&node,
	}
	node1.Print()
	fmt.Println()
	function.FuncUse()
}