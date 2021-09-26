package main

import (
	"flag"
	"fmt"
	"logchange/server"
	"os"
)

var (
	file string
	//监听的文件夹
	dir     string
	split   string
	execStr string
)

func main() {
	fmt.Println("start server")
	flag.StringVar(&dir, "d", "", "监听的文件夹")
	flag.StringVar(&file, "f", "", "监听的文件")
	flag.StringVar(&split, "s", "", "监听到内容的分隔符")
	flag.StringVar(&execStr, "e", "", "对内容分割后的操作")
	flag.Parse()
	if len(dir) == 0 && len(file) == 0 {
		fmt.Println("监听的文件/文件夹不能全为为空, -d 传入 文件夹 -f 传入单个文件")
		os.Exit(0)
	}
	args := server.Args{
		File:  file,
		Dir:   dir,
		Split: split,
		Exec:  execStr,
	}
	server.GetChangeInfo(args)
}