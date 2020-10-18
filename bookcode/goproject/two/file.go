package main

import (
	"fmt"
	"io/ioutil"
)

func main() {
	fmt.Println("文件操作")
	readwritefile()
}

//读写临时文件
func readwritefile() {
	file, err := ioutil.TempFile("d:/test/", "tmpfile")
	if err != nil {
		panic(err)
	}
	//defer 
	defer func() {
		file.Close()
		// 一般来说，临时文件不用了，需要移除
		// err := os.Remove(file.Name())
		// if err != nil {
		// 	log.Fatal(err.Error())
		// }
	}()
	//日志内容
	logStr := "test info"
	if _, err := file.Write([]byte(logStr)); err != nil {
		panic(err)
	}

	fmt.Println("file.Name = " + file.Name())
}
