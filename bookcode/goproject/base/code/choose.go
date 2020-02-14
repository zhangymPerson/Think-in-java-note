package code

import (
	"fmt"
)

//go 判断语句写法
func ChooseOne() string {
	if true {
		fmt.Println("true")
	}
	//定义变量的方式
	var a int = 5
	b := 10

	if a > b {
		fmt.Println(a, ">", b)
	} else if a < b {
		fmt.Println(a, "<", b)
	} else {
		fmt.Println(a, "=", b)
	}

	/* 判断条件 */
	if a == 100 {
		/* if 条件语句为 true 执行 */
		if b == 200 {
			/* if 条件语句为 true 执行 */
			fmt.Printf("a 的值为 100 ， b 的值为 200\n")
		}
	}
	return "调用选择函数测试1成功"
}
