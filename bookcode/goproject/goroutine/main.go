package main

import (
	"fmt"
	"time"
)

func main() {
	fmt.Println("1. 开始执行--主程序")
	n := 3

	// We want to run a goroutine to multiply n by 2
	//协程的使用 go 加命令
	go multiplyByTwo(n)

	// time.Sleep(time.Second)        //  主程序第一次挂起, 程序会切换到协程上执行
	fmt.Println("4. 哈哈, 我又执行主程序了")
	time.Sleep(time.Second)		   //  主程序第二次挂起
	fmt.Println("6. 不切换了!")
}

func multiplyByTwo(num int) int {
	fmt.Println("2. 开始执行--协程")
	result := num * 2
	fmt.Println("3. 协程计算结果:", result)
	// time.Sleep(time.Second)    // 主动挂起, 此时有两个挂机的
	fmt.Println("5. 切换到协程了")
	return result
}