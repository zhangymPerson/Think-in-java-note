package funcs

import (
	"fmt"
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




func TestStruct(){
	age := 12
	p:=Person{"男","张三",12,&age,nil,nil}
	//结构体本身是值类型
	p1 := p
	p1.sex="女"
	p1.Name="李四"
	//其中p 和 pp 是两块不同的内存，之间是值传递
	fmt.Println(p)
	fmt.Println(p1)
	//引用传递
	p2 := &p
	fmt.Println("-----------------------------------------------------------------")
	p2.Name="你猜我改的是谁"
	fmt.Println(p)
	fmt.Println(*p2)
}


//方法

// func (Person) toString() string {
// 	fmt.Print()
// }