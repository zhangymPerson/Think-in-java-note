package function

import "fmt"

//函数作为变量是第一等公民
//定义一个函数类型
type function func(int) int

//定义函数变量
var f function

func FuncUse() {
	f = func(a int) int {
		return a
	}

	res := f(12)

	fmt.Printf("res = %v\n", res)

	f = func(a int) int {
		return a + a
	}

	f(11)
}

//定义一个Person对象
type Person struct{
	//
	Id int
	Sex string
	Name string
	Age int
	//其他信息
	info map[string]string
}

func (p  *Person) Print() {
	fmt.Printf("个人信息：id = %v,性别 = %v,姓名 = %v,年龄 = %v",p.Id,p.Sex,p.Name,p.Age)
}

//匿名函数
func (p *Person) anonymityFunc(){
	res := func (a int,b int) int{
		return a+b
	}(10,11)
	fmt.Printf("p = %v,res = %v\n",p,res)
}
