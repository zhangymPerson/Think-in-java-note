package main

import (
	"flag"
	"fmt"
	"os"
	"os/exec"

	"github.com/fsnotify/fsnotify"
)

var (
	//监听的文件夹
	dir string
)

func main() {
	fmt.Println("start server")
	flag.StringVar(&dir, "d", "", "监听的文件夹")
	// flag.StringVar(&fileName, "f", "", "监听的文件夹")
	flag.Parse()
	if len(dir) == 0 {
		fmt.Println("监听的文件夹不能为空, -d 传入")
		os.Exit(0)
	}
	FileChange(dir)
}

// FileChange 判断文件是否变动 dir要监控的文件夹 bool
func FileChange(dir string) bool {
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
				if event.Op == 1 || event.Op == 2 {
					name := event.Name
					// fmt.Printf("文件 [%s] 进行了 [%s] 操作\n", name, event.Op)
					changInfo := getFileLastInfo(name)
					//此处打印最后一行内容，可根据具体文件内容进行扩展
					analysisLog(changInfo)
				}
			case err, ok := <-watcher.Errors:
				if !ok {
					return
				}
				fmt.Println("error:", err)
			}
		}
	}()
	err = watcher.Add(dir)
	if err != nil {
		fmt.Printf("监控目录[ %s ]失败,err %s", dir, err)
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
		fmt.Errorf(err.Error())
		return ""
	}
	// fmt.Printf("文件 [%s] 最后一行改动为: [%s] \n", file, string(b))
	return string(b)
}

// analysisLog 分析最后一行日志的内容
func analysisLog(log string) {
	//此处只打印，可自定义扩展
	fmt.Printf(log)
}
