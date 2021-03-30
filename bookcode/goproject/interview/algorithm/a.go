package main

import "fmt"

type ListNode struct {
	value int
	next  *ListNode
}

func (l *ListNode) String() string {
	return fmt.Sprintf("node[value=%v,next=%v]", l.value, l.next)
}

func reverse(node *ListNode) ListNode {
	if node.next == nil {
		return *node
	}
	newnode := reverse(node.next)
	node.next.next = node
	node.next = nil
	return newnode
}

func main() {
	node := ListNode{
		value: 1,
		next: &ListNode{
			value: 2,
			next: &ListNode{
				value: 3,
				next:  nil,
			},
		},
	}
	fmt.Printf("node=%v\n", node)
	reverse(&node)
	fmt.Printf("node=%v\n", node)
}
