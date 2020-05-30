package model

import (
	"fmt"
)

type TreeNode struct {
	Value       int
	Left, Right *TreeNode
}

/**
* 指针接收者
 */
func (node *TreeNode) Print() {
	if node == nil {
		fmt.Print("node = %s 是个nil")
	}
	fmt.Printf("node value = %v,left = %v.right = %v", node.Value, node.Left, node.Right)
}
