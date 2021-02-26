package question

import (
	"fmt"
)

//DeferCall 测试执行顺序
//先打印 后 中 前 然后才执行 异常
func DeferCall() {
	defer func() { fmt.Println("打印前") }()
	defer func() { fmt.Println("打印中") }()
	defer func() { fmt.Println("打印后") }()
	// panic("触发异常")
}

//Two 测试引用赋值
func Two() {
	slice := []int{0, 1, 2, 3}
	m := make(map[int]*int)

	for key, val := range slice {
		value := val
		m[key] = &value
		// 错误写法如下
		// m[key] = &val
	}

	for k, v := range m {
		fmt.Println(k, "->", *v)
	}
}
