package funcs

import (
	"fmt"
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
//结构体本身是值传递
func (p Person) sayHello() {
	//结构体的值传递 不会影响 调用的实例对象
	p.Name = "Hello"
	fmt.Println(p.Name + " say Hello!")
} 

//指针是引用传递
func (p *Person) sayHi() {
	//引用传递修改 会影响 调用的实例
	p.Name = "Hi"
	fmt.Println(p.Name + " say Hi")
}

//方法值传递和引用传递的对比测试
func TestStructTwo(){
	age := 12
	p:=Person{"男","张三",12,&age,nil,nil}
	fmt.Println("原生的 p = ",p)
	p.sayHello()
	fmt.Println("值传递之后的p = ",p)
	p.sayHi()
	fmt.Println("引用传递之后的p = ",p)
}



func TestStructOne(){
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
