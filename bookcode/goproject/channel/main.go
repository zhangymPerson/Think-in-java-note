package main

import (
	"fmt"
)

//定义全局channel
var (
	//定义管道的方式
	intChann chan int    = make(chan int, 3)
	strChan  chan string = make(chan string, 2)
)

func main() {
	fmt.Println("hello word")
	// fmt.Println(s)
	fmt.Println(a)
	//管道赋值 管道是队列机制，FIFO 
	intChann <- 3
	intChann <- 4
	num := <-intChann
	fmt.Println(num)
	intChann <- 5
	// 管道有数量限制，超过报错
	// intChann <- 6
	strChan <- "one"
}
