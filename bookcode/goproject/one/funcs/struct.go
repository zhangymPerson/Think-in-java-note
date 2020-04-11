package funcs

import (
	_ "fmt"
)

type Person struct{
	//私有字段
	sex string
	//公有字段
	Name string
	age int
	//特殊类型 值都是 nil 未分配空间
	Age *int //指针
	//下面的类型使用需要先 make 下
	Slice []int //切片
	Maps map[string]string //

}

//方法

// func (Person) toString() string {
// 	fmt.Print()
// }