package question

import "fmt"

//1、iota只能在常量的表达式中使用。
// 2、每次 const 出现时，都会让 iota 初始化为0.【自增长】
const (
	x = iota
	// 可以使用下划线跳过不想要的值
	_
	y
	z = "zz"
	k
	p = iota
)

// Obj 测试使用的一个结构体
type Obj struct {
	name string
	age  int32
}

// IotaTest 测试 iota 的特性
func IotaTest() {
	fmt.Println(x, y, z, k, p)
}

//值传递 引用传递

//MethodArgTest 测试值传递
func MethodArgTest() {
	fmt.Println("值/引用传递")
	var i int32 = 32
	addOne(i)
	fmt.Println("i = ", i)
	obj := Obj{
		name: "name",
		age:  12,
	}
	fmt.Printf("%v \n", obj)
	alterObjOne(obj)
	fmt.Printf("%v \n", obj)
	alterObjTwo(&obj)
	fmt.Printf("%v \n", obj)

}

func addOne(i int32) {
	i = i + 1
}

func alterObjOne(obj Obj) {
	obj = Obj{
		name: "one",
		age:  1,
	}
	obj.age = 1
	fmt.Printf("one is %v \n", obj)
}

func alterObjTwo(obj *Obj) {
	obj = &Obj{
		name: "two",
		age:  2,
	}
	obj.age = 22
	fmt.Printf("two is %v \n", obj)
}
