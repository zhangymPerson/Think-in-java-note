package main

import (
	"fmt"
	"strconv"
	"time"

	"./funcs"
)

//函数

func main() {
	fmt.Print("测试")
	// test()
	t := time.Now()
	n := 1000000
	StrAppend(n)
	elapsed := time.Since(t)
	fmt.Println("app elapsed:", elapsed)
}

func test() {
	//这个是私有函数
	// funcs.privateFunc()
	funcs.PublicFunc()
	fmt.Println("----------------------------------")
	funcs.TestStructOne()
	fmt.Println("----------------------------------")
	funcs.TestStructTwo()
	fmt.Println("----------------------------------")
	var p funcs.Person
	p.Name = "测试"
	a := 23
	p.Age = &a
	//定义切片
	ints := []int{1, 2, 3}
	//集合
	maps := make(map[string]string)
	maps["key"] = "value"
	maps["key1"] = "value1"
	maps["key2"] = "value2"
	p.Maps = maps
	p.Slice = ints
	fmt.Print(p)
}

//StrAppend is 字符串拼接测试
func StrAppend(n int) {
	var a = "a"
	for i := 0; i < n; i++ {
		a = a + strconv.Itoa(i)
	}
	fmt.Printf("a的长度%v\n", len(a))
	// fmt.Printf("a=%v\na的长度%v\n", a, len(a))
}
