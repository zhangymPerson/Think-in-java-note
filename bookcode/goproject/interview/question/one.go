package question

import (
	"fmt"
)

//DeferCall 测试执行顺序
//先打印 后 中 前 然后才执行 异常
func DeferCall() {
	defer func() { fmt.Println("打印前") }()
	defer func() { fmt.Println("打印中") }()
	defer func() { fmt.Println("打印后") }()
	// panic("触发异常")
}

//Two 测试引用赋值
func Two() {
	slice := []int{0, 1, 2, 3}
	m := make(map[int]*int)

	for key, val := range slice {
		value := val
		m[key] = &value
		// 错误写法如下
		// m[key] = &val
	}

	for k, v := range m {
		fmt.Println(k, "->", *v)
	}
}

//切片的赋值比较
// SliceOne slice append test
func SliceOne() {
	s := make([]int, 5)
	s = append(s, 1, 2, 3)
	fmt.Println(s)
}

// SliceTwo slice append test
func SliceTwo() {
	s := make([]int, 0)
	s = append(s, 1, 2, 3, 4)
	fmt.Println(s)
}

func SliceTest() {
	var array = []int{1, 2, 3, 4, 5} // len:5,capacity:5
	var newArray = array[1:3]        // len:2,capacity:4   (已经使用了两个位置，所以还空两位置可以append)
	fmt.Printf("%p\n", array)        //0xc420098000
	fmt.Printf("%p\n", newArray)     //0xc420098008 可以看到newArray的地址指向的是array[1]的地址，即他们底层使用的还是一个数组
	fmt.Printf("%v\n", array)        //[1 2 3 4 5]
	fmt.Printf("%v\n", newArray)     //[2 3]

	newArray[1] = 9              //更改后array、newArray都改变了
	fmt.Printf("%v\n", array)    // [1 2 9 4 5]
	fmt.Printf("%v\n", newArray) // [2 9]

	newArray = append(newArray, 11, 12) //append 操作之后，array的len和capacity不变,newArray的len变为4，capacity：4。因为这是对newArray的操作
	fmt.Printf("%v\n", array)           //[1 2 9 11 12] //注意对newArray做append操作之后，array[3],array[4]的值也发生了改变
	fmt.Printf("%v\n", newArray)        //[2 9 11 12]

	newArray = append(newArray, 13, 14) // 因为newArray的len已经等于capacity，所以再次append就会超过capacity值，
	// 此时，append函数内部会创建一个新的底层数组（是一个扩容过的数组），并将array指向的底层数组拷贝过去，然后在追加新的值。
	fmt.Printf("%p\n", array)    //0xc420098000
	fmt.Printf("%p\n", newArray) //0xc4200a0000
	fmt.Printf("%v\n", array)    //[1 2 9 11 12]
	fmt.Printf("%v\n", newArray) //[2 9 11 12 13 14]  他两已经不再是指向同一个底层数组y了
}
