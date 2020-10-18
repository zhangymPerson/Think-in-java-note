package main

//执行前需要 go mod init two
//然后 go run ./
import (
	"fmt"
	"math/rand"
	"sort"
)

func main() {
	fmt.Println("test")
	var list StudentList
	for i := 0; i < 10; i++ {
		stu := Student{
			Name:  fmt.Sprintf("stu%v", rand.Intn(10)),
			Age:   23,
			Score: rand.Intn(100),
		}
		list = append(list, stu)
	}
	for _, v := range list {
		fmt.Println(v)
	}
	sort.Sort(list)
	fmt.Println("----------------------------------------------------------------------------------------")
	for _, v := range list {
		fmt.Println(v)
	}

}
