package question

import "fmt"

// MyInt1 定义结构体
// 基于类型 int 创建了新类型 MyInt1，
type MyInt1 int

// MyInt2 定义结构体
//创建了 int 的类型别名 MyInt2
type MyInt2 = int

// StructType 测试 结构体的定义 和 别名的比较
func StructType() {
	var i int = 0
	// 一下语句报错
	// var i1 MyInt1 = i
	var i1 MyInt1 = MyInt1(i)
	var i2 MyInt2 = i
	fmt.Println(i1, i2)
}

// StructTest 结构体比较
func StructTest() {
	sn1 := struct {
		age  int
		name string
	}{age: 11, name: "qq"}

	var name string
	name = sn1.name
	name = (&sn1).name
	// name = (*sn1).name
	// name:=sn1->name
	fmt.Println(name)


	sn2 := struct {
		age  int
		name string
	}{age: 11, name: "qq"}

	if sn1 == sn2 {
		fmt.Println("sn1 == sn2")
	}

	sm1 := struct {
		age int
		m   map[string]string
	}{age: 11, m: map[string]string{"a": "1"}}
	sm2 := struct {
		age int
		m   map[string]string
	}{age: 11, m: map[string]string{"a": "1"}}

	//结构体只能比较是否相等，但是不能比较大小。
	//相同类型的结构体才能够进行比较，结构体是否相同不但与属性类型有关，还与属性顺序相关，sn3 与 sn1 就是不同的结构体；
	// if sm1 == sm2 {
	if sm1.age == sm2.age {
		fmt.Println("sm1 == sm2")
	}

}
