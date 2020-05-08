package code

import (
	"fmt"
)



//:=这个符号直接取代了var和type,这种形式叫做简短声明。不过它有一个限制，那就是它只能用在函数内部；在函数外部使用则会无法编译通过，
//所以一般用var方式来定义全局变量。


// go变量的一些特性
// 并行 或 同时 赋值。
// 如果你想要交换两个变量的值，则可以简单地使用 a, b = b, a，两个变量的类型必须是相同。
// 空白标识符 _ 也被用于抛弃值，如值 5 在：_, b = 5, 7 中被抛弃。
// _ 实际上是一个只写变量，你不能得到它的值。这样做是因为 Go 语言中你必须使用所有被声明的变量，但有时你并不需要使用从一个函数得到的所有返回值。
// 并行赋值也被用于当一个函数返回多个返回值时，比如这里的 val 和错误 err 是通过调用 Func1 函数同时得到：val, err = Func1(var1)。
func VarTest() {
	fmt.Println("测试变量")
	//报错 .\choose.go:16:6: c declared and not used
	//var c string = "测试无引用的局部变量"
	d := "局部变量有引用"
	fmt.Println(d)
	_, numb, strs := numbers() //只获取函数返回值的后两个
	fmt.Println(numb, strs)
}

//一个可以返回多个值的函数
func numbers() (int, int, string) {
	a, b, c := 1, 2, "str"
	return a, b, c
}
