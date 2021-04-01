package test

import "fmt"

//测试数字计算

func DivisionOne() {
	var a, b float32
	c := a / b
	//输出NoN
	fmt.Printf("DivisionOne = %f\n", c)
}

func DivisionTwo() {
	var a, b float32
	a = 1
	b = 0
	c := a / b
	//infinity 类型
	//+Inf
	fmt.Printf("DivisionTwo = %f\n", c)
}

func DivisionThree() {
	var a, b int
	a = 1
	b = 0
	//panic: runtime error: integer divide by zero
	c := a / b
	fmt.Printf("DivisionThree = %d\n", c)
}

func DivisionFore() {
	var a, b int
	//panic: runtime error: integer divide by zero
	c := a / b
	fmt.Printf("DivisionThree = %d\n", c)
}
