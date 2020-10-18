package main

import (
	"fmt"
)

func main(){
	var a bool = true
	var b bool = false
	f1 := a&&b
	f2 := a||b
	fmt.Println(f1,f2)
	if ( a && b ) {
	   fmt.Printf("第一行 - 条件为 true\n" )
	}
	if ( a || b ) {
	   fmt.Printf("第二行 - 条件为 true\n" )
	}
	/* 修改 a 和 b 的值 */
	a = false
	b = true
	f3 := a&&b
	f4 := a||b
	fmt.Println(f3,f4)	
	if ( a && b ) {
	   fmt.Printf("第三行 - 条件为 true\n" )
	} else {
	   fmt.Printf("第三行 - 条件为 false\n" )
	}
	if ( !(a && b) ) {
	   fmt.Printf("第四行 - 条件为 true\n" )
	}


	//类型转换
	var sum int = 17
	var count int = 5
	var mean float32
	//显示转化
	mean = float32(sum)/float32(count)
	fmt.Printf("mean 的值为: %f\n",mean)

	num :=1000
	if num >0 && num <100 {
		fmt.Printf("0<%v<100",num)
	}else {
		fmt.Printf("%v <= 0 或者 %v >= 100 ",num,num)
	}
}