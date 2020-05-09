package main

import (
	"fmt"
)

var (
	//管道关键字 chan
	intChan chan int         = make(chan int, 10)
	resChan chan map[int]int = make(chan map[int]int, 20)
)

//初始化管道
func initInt(max int) {
	for i := 0; i < max; i++ {
		intChan <- i
	}
	close(intChan)
}

//测试管道
func testGoroutine() {
	n := <-intChan
	res := make(map[int]int)
	res[n] = n * n
	resChan <- res
}

func main() {

	go initInt(20)
	for i := 0; i < 12; i++ {
		go testGoroutine()
	}

	close(resChan)
	for res := range resChan {
		fmt.Println(res)
	}
	fmt.Println("test", resChan)
}
