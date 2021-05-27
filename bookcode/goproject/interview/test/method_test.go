package test

import (
	"fmt"
	"testing"
)

func division(one, two float64) (int, error) {
	//异常捕获
	//defer func() (int, error) {
	//	err := recover()
	//	fmt.Printf("函数运行异常，异常信息:%s\n", err)
	//	return 0, errors.New(fmt.Sprintf("%s", err))
	//}()
	three := one / two
	return int(three), nil
}

func Test_Division_1(t *testing.T) {
	if i, e := division(6, 0); i != 3 || e != nil {
		//try a unit test on function
		// 如果不是如预期的那么就报错
		t.Logf("除法函数测试没通过,i=[%d],e=[%s]", i, e)
	} else {
		//记录一些你期望记录的信息
		t.Log("第一个测试通过了")
	}
}

// exception 测试异常捕获的方式  defer 捕获
func exception() {
	defer func() {
		if e := recover(); e != nil {
			fmt.Printf("test try method exception %s\n", e)
		}
	}()
	one := 0
	num := 1 / one
	fmt.Printf("num=%d", num)
}

func TestException(t *testing.T) {
	exception()
	t.Log("test method exception success!")
}
