package main

import (
	"fmt"
	"./funcs"
)


//函数

func main(){
	fmt.Print("测试")
	//这个是私有函数
	// funcs.privateFunc()
	funcs.PublicFunc()
	fmt.Println("----------------------------------")
	funcs.TestStruct()
	fmt.Println("----------------------------------")
	var p funcs.Person
	p.Name="测试"
	a := 23
	p.Age = &a
	//定义切片
	ints :=[]int{1,2,3}
	//集合
	maps := make(map[string]string)
	maps["key"]="value"
	maps["key1"]="value1"
	maps["key2"]="value2"
	p.Maps=maps
	p.Slice = ints
	fmt.Print(p)
}