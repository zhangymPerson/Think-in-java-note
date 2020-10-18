package main

import "fmt"

func main() {
	stackingDefers()
}

//defer 关键字
// 类似Java中的 finally 语句  C++语言里的析构函数(Destructor)可以起类似的作用
//defer后面必须是函数调用语句，不能是其他语句，否则编译器会出错。
//多个执行顺序是 3 - 2  - 1 
func stackingDefers() {
	//先进后出 FILO
	defer func() {
		fmt.Println("1")
	}()
	defer func() {
		fmt.Println("2")
	}()
	defer func() {
		fmt.Println("3")
	}()
}
