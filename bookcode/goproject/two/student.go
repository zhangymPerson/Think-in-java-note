package main
import (
	"encoding/json"
	"fmt"
)
//结构体
type Student struct {
	Name  string
	Age   int
	Score int
}

// Set方法
func (stu * Student) SetName(name string) {
	stu.Name = name
}


// 自定义切片
type StudentList []Student

//实现了 sort.Sort(data Interface) interface中接口所有的函数

func (stu StudentList) Len() int {
	return len(stu)
}

func (stu StudentList) Less(i, j int) bool {
	return stu[i].Score < stu[j].Score
}

func (stu StudentList) Swap(i, j int) {
	stu[i], stu[j] = stu[j], stu[i]
}

//用户
type User struct {
	UserName string `json:"username"`
	Age 	 int    `json:"age"`
	Sex      string `json:"sex"`
	Email    string `json:"email"`
	Phone    string `json:"phone"`
}


func main(){
	//构造对象
	user := User{
		UserName: "itbsl",
		Age:   	  18,
		Sex:      "itbsl@gmail.com",
		Phone:    "176XXXX6688", //最后一个逗号必须有
	}
	//转json
	data, err := json.Marshal(user)
	if err != nil{
		fmt.Println(err)
	}
	fmt.Println(string(data))
}