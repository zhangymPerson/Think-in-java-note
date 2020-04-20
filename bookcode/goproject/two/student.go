package main

//结构体
type Student struct {
	Name  string
	Age   int
	Score int
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
