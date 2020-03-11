package code

import "fmt"

type ClassObj struct {
	Width  float64
	Height float64
}

//可以理解为ClassObj的成员方法
func (co ClassObj) Area() float64 {
	return co.Width * co.Height
}

//修改自身内容都可以成功
func TestArrAndSliceOne() {
	//切片
	a := []string{"a", "b"}
	//数组
	b := [2]string{"c", "d"}
	fmt.Println("修改自己前", a, b)
	//修改自己
	a[1] = "A"
	b[1] = "B"
	//修改成功
	fmt.Println("修改自己后", a, b)

}

//修改应用对象
func TestArrAndSliceTwo() {
	//切片
	a := []string{"a", "b"}
	//数组
	b := [2]string{"c", "d"}
	fmt.Println("修改引用前", a, b)
	//创建引用
	aa := a
	bb := b
	//修改引用
	//切片修改后会修改原引用对象
	//数组修改后不会影响就的数组内容
	aa[1] = "A"
	bb[1] = "B"
	//修改成功
	fmt.Println("修改引用后", a, b)

}
