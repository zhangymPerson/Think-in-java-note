package code

//函数练习

import "fmt"

/*-----------struct 类型学习--------------*/
type User struct {
	name string
	age  int
}

/*-----------struct 类型嵌套学习--------------*/
type Person struct {
	User //默认“继承”了User所有的内容
	sex  int
}

func FunTest() {
	fmt.Println("-------------------类型强转------------------------------")
	i1 := 1
	var f1 float32
	f1 = float32(i1)
	fmt.Printf("print:%f", f1)
	fmt.Println()
	fmt.Println("-------------------struct------------------------------")
	p1 := Person{User{"zhouwei", 27}, 1}
	fmt.Println(p1.User)         //可以直接打印User所有内容
	fmt.Println(p1.name, p1.sex) //也可以打印继承的属性
	fmt.Println("----------------------method----------------------------")
	var compareResult int
	compareResult = compare(1, 2)
	fmt.Printf("compare result is %d", compareResult)
	fmt.Println()
	array1 := []int{1, 2, 3, 4}                     //定义数组
	a1, a2 := getFirstAndSecondFromArray(array1, 4) //调用并获取返回值
	fmt.Println(a1, a2)
	printSomething(3)
	fmt.Println("----------------------map----------------------------")
	mapLearn()
	sliceLearn()
	fmt.Println("----------------------递归算法----------------------------")
	fac := Factorial(3)
	fmt.Printf("res:%d", fac)
	fmt.Println("------------------斐波那契数列 -----------------")
	fi := fibonacci(5)
	fmt.Printf("fibonacci:%d", fi)
	fmt.Println()
}

/* 斐波那契数列 */
func fibonacci(n int) int {
	if n <= 2 {
		//fmt.Println(n);
		return n - 1
	} else {
		return fibonacci(n-1) + fibonacci(n-2)
	}
}

/*   递归    */
func Factorial(n int) int {
	if n == 0 {
		return n
	} else {
		return n + Factorial(n-1)
	}
}

func sliceLearn() {
	var sli = []int{1, 2, 3}
	for sl := range sli {
		fmt.Println(sl)
	}
}

func mapLearn() {
	m1 := make(map[string]string)
	m1["1"] = "1"
	m1["2"] = "2"
	m1["3"] = "3"
	fmt.Println(m1)
	fmt.Println(m1["1"])
	m2 := map[int]int{1: 1, 2: 2}
	for _, v := range m2 {
		fmt.Printf("~ -> %d\n", v)
	}

}

/*-----------函数无返回值--------------*/
func printSomething(size int) {
	for i := 0; i < size; i++ {
		if i == 2 {
			break
		}
		fmt.Print(i, "\t")
	}
	fmt.Println()
	//这种用法像while
	i := 0
	for i < size {
		i++
		if i == 2 {
			continue
		}
		fmt.Print(i, "\t")

	}
	fmt.Println()
	switch i {
	case 1, 2:
		{
			fmt.Print("12case:", i, "\t")
		}
	case 3:
		fmt.Print("3case:", i, "\t")
		fallthrough //不加，默认是加了break，匹配率了就结束了，加了这个关键字 强制执行后面第一个case的代码
	case 4, 5:
		{
			fmt.Print("45case:", i, "\t")
		}
	case 6:
		fmt.Print("ca6se:", i, "\t")
	default:
		fmt.Print("no:")
	}
}

/*-----------函数单个返回值--------------*/
func compare(a int, b int) int {
	if a > b {
		return 1
	} else if a == b {
		return 0
	} else {
		return 2
	}
}

/*-----------函数多个返回值--------------*/
func getFirstAndSecondFromArray(a []int, size int) (int, int) {
	if size <= 1 {
		return 0, 0
	} else {
		return a[0], a[1]
	}
}
