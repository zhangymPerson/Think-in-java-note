package main

// 测试 channel 相关api

import (
	"fmt"
	"testing"
)

// readChan 单通道的channel
func readChan(chanName <-chan int) {
	for i := 0; i < 2; i++ {
		a := <-chanName
		fmt.Println(a)
	}
}

func writeChan(chanName chan<- int) {
	chanName <- 1
	chanName <- 2
	chanName <- 3
	chanName <- 4
}

func TestChannelOne(t *testing.T) {
	//定义一个 channel
	var mychan = make(chan int, 10)
	writeChan(mychan)
	readChan(mychan)
}

func TestChannel(t *testing.T) {

	// 管道的使用
	// 1.创建一个可以存放3个int类型的管道
	var intChan chan int
	intChan = make(chan int, 3)
	// 2.查看intChan 是什么?
	fmt.Printf("intchan:%v\n", intChan) // 输出结果： intchan:0xc00008c080 可以看出是引用类型
	// 3.向管道写入数据
	intChan <- 10
	num := 100
	intChan <- num // 也可以写入常量
	intChan <- 20
	// 下面这行代码报错
	// 因为 intChan 已经写满 报错: fatal error: all goroutines are asleep - deadlock!
	// intChan <- 40
	// 4.看看管道的长度和cap(容量：定义的长度跟容量是相等的, 不同于map类型等)
	fmt.Printf("channel len=%v cap=%v\n", len(intChan), cap(intChan))
	//  4输出结果：channel len=2 cap=3

	//5.从管道中读取数据
	//var num2 int
	num2 := <-intChan
	fmt.Println("取出的num2=", num2)
	fmt.Printf("channel len=%v cap=%v\n", len(intChan), cap(intChan))
	// 5输出结果：channel len=1 cap=3

}

// closeChannel 测试关闭管道
func TestCloseChannel(t *testing.T) {
	// 创建一个管道,大小为3
	intChan := make(chan int, 3)
	intChan <- 3
	intChan <- 5
	// 将管道进行关闭
	close(intChan)
	// 此时会无法写入, 因为管道已经关闭: 报错信息 panic: send on closed channel
	//intChan <-6
	n1 := <-intChan
	fmt.Println("可以从管道中读取值:", n1)
}
