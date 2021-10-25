package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

//初始化内容可以在这里开展
func init() {
	fmt.Println("init work")
}

//run 执行的脚本内容
func run() {
	fmt.Println("do task")
	infos := ReadFile("README.md")
	for _, info := range infos {
		fmt.Println(info)
	}
	AppendFile("test.txt", "test")
	AppendFile("test.txt", "testOne")
	AppendFile("test.txt", "testTwo\n\n")
	AppendFile("test.txt", "testThree")
}

// 读文件
func ReadFile(filename string) []string {
	lines, err := ioutil.ReadFile(filename)
	var res []string
	if err != nil {
		fmt.Println(err)
	} else {
		return strings.Split(string(lines), "\n")
	}
	return res
}

// 追加内容到文件中
func AppendFile(fileName string, text string) {
	// O_APPEDN 追加方式
	file, err := os.OpenFile(fileName, os.O_WRONLY|os.O_APPEND, 0666)
	if err != nil {
		// 文件不存在则创建
		os.Create(fileName)
		file, _ = os.OpenFile(fileName, os.O_WRONLY|os.O_APPEND, 0666)

	}
	defer file.Close()
	writer := bufio.NewWriter(file)
	//内容不换行，则默认添加换行符
	if !HasSuffix(text, "\n") {
		text = text + "\n"
	}
	writer.WriteString(text)
	writer.Flush()
}

// 判断字符串结尾
func HasSuffix(s, suffix string) bool {
	return len(s) >= len(suffix) && s[len(s)-len(suffix):] == suffix
}

// 脚本入口
func main() {
	fmt.Println("script")
	run()
}
