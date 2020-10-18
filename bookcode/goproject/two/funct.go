package main

import "fmt"

func main()  {
	fmt.Println("函数测试")	
	funcname()
	arg := "string参数"
	num := 12
	f := 23.32
	funcnameA(arg,num,f)

	argB :=funcnameB(arg)
	fmt.Println(argB)

	arg1,arg2,arg3 := funcnameC()
	fmt.Printf("参数是 %v,%v，%v\n",arg1,arg2,arg3)
}

func funcname(){
	//do
}

func funcnameA(arg string,num int,f float64){
	fmt.Printf("参数1=%v,参数2=%v,参数3=%v\n",arg,num,f)
}

func funcnameB(arg string) string {
	return arg+"..."
}

//多返回值时 官方建议：最好命名返回值，
func funcnameC() (string,int,float32){
	return "funcC",12,12.3
}

func funcnameD()(arg string,num int,f float32){
	arg = "funcD"
	num = 23
	f = 23.3
	return
}