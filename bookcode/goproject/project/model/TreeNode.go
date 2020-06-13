package model

import (
	"fmt"
	"log"
)

/**
自定义结构体
*/
type TreeNode struct {
	//首字母大写则包外可用，否则不可用
	Value int
	//指针类型的对象
	Left, Right *TreeNode
}

/**
Go语言当中的方法 ，属于当前对象的
指针接收者
*/
func (node *TreeNode) Print() {
	log.Println("请求的是方法，首字母大写为公有方法，请求的参数是 = ", node)
	if node == nil {
		fmt.Print("node 是个nil")
	}
	fmt.Printf("node value = %v,left = %v.right = %v", node.Value, node.Left, node.Right)
}

/**
go语言的方法和函数没有本质区别，这个是函数 ，上面的写法就是方法 隶属于 TreeNode结构体的函数
*/
func Prints(node *TreeNode) {
	log.Println("请求的是函数，首字母大写为公有函数，请求的参数是 = ", node)
	if node == nil {
		fmt.Print("node 是个nil")
	}
	fmt.Printf("node value = %v,left = %v.right = %v", node.Value, node.Left, node.Right)
}
