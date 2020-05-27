package main

import (
	"project/model"
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
}