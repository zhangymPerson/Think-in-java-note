package server

import (
	"fmt"
	"io/ioutil"
	"os/exec"
	"strings"

	"github.com/fsnotify/fsnotify"
)

//GetChangeInfo 获取文件变化
func GetChangeInfo(args Args) bool {
	dir := args.Dir
	file := args.File
	if len(file) == 0 {
		if len(dir) == 0 {
			return false
		} else {
			file = dir
		}
	}
	fmt.Println(args.String())
	watcher, err := fsnotify.NewWatcher()
	if err != nil {
		fmt.Println("NewWatcher failed: ", err)
	}
	defer watcher.Close()
	done := make(chan bool)
	go func() {
		defer close(done)
		for {
			select {
			case event, ok := <-watcher.Events:
				if !ok {
					return
				}
				//Op 1 = 创建 2 写入
				name := event.Name
				if event.Op == 1 || event.Op == 2 {
					// fmt.Printf("文件 [%s] 进行了 [%s] 操作\n", name, event.Op)

					// 获取文件最后一行输入内容
					changInfo := getFileLastInfo(name)
					// 根据分割符获取内容
					info := analysisLog(changInfo, args.Split)
					//执行后续的脚本
					endExec(info, args.Exec)
				}
			case err, ok := <-watcher.Errors:
				if !ok {
					return
				}
				fmt.Println("error:", err)
			}
		}
	}()
	err = watcher.Add(file)
	if err != nil {
		fmt.Printf("监控内容[ %s ]失败,err %s", file, err)
	}
	<-done
	return true
}

// getFileLastInfo获取指定文件的最后一行数据
func getFileLastInfo(file string) string {
	// 查看指定文件的最后一行内容
	shell := fmt.Sprintf("cat %s | sed -n '$P'", file)
	// fmt.Printf("shell = [%s] \n", shell)
	c := exec.Command("bash", "-c", shell)
	b, err := c.Output()
	if err != nil {
		fmt.Println(err.Error())
		return ""
	}
	// fmt.Printf("文件 [%s] 最后一行改动为: [%s] \n", file, string(b))
	return string(b)
}

// analysisLog 分析最后一行日志的内容
func analysisLog(log string, split string) string {
	// 无分割符时
	if len(split) == 0 {
		return log
	}
	//此处只打印，可自定义扩展
	infos := strings.Split(log, split)
	infoStr := ""
	for _, v := range infos {
		infoStr += fmt.Sprintf("%v\n", v)
	}
	return infoStr
}

func endExec(info string, execStr string) {
	if len(execStr) == 0 {
		fmt.Println(info)
	}
	//写入文件中提供分析 需改动
	fileName := "script.log"
	ioutil.WriteFile(fileName, []byte(info), 0666)
	shell := fmt.Sprintf("cat %s| %s", fileName, execStr)
	fmt.Printf("shell = [%s] \n", shell)
	c := exec.Command("bash", "-c", shell)
	b, _ := c.Output()
	fmt.Println(string(b))
}
