package function

import "fmt"

//函数作为变量是第一等公民
//定义一个函数类型
type function func(int) int
//定义函数变量
var f function

func FuncUse(){
	f = func(a int) int{
		return a
	}
	
	res := f(12)

	fmt.Printf("res = %v\n",res)

	f = func(a int) int{
		return a+a
	}

	f(11)
}