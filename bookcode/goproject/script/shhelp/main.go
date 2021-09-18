package main

import (
	"encoding/json"
	"flag"
	"fmt"
	"io/ioutil"
	"os"
	"os/exec"
	"reflect"
)

type Command struct {
	Id      int64    `json:"id"`
	Command string   `json:"command"`
	Args    []string `json:"args"`
	Info    string   `json:"info"`
}

type Commands struct {
	Commands []Command `json:"commands"`
}

var (
	help     bool
	num      int64
	file     string
	filePath = "./command.json"
)

func main() {
	fmt.Println("start server")
	// fmt.Println("命令行的参数有", len(os.Args))
	// &user 就是接收命令行中输入 -u 后面的参数值，其他同理
	flag.Int64Var(&num, "id", 0, "命令id")
	var fileInfo string = `json配置文件位置，格式如下：
{
	"commands": [
		{
			"id": 1,
			"command": "ls",
			"args": [
				"-la"
			],
			"info": "查看命令"
		}
	]
}
	`
	flag.StringVar(&file, "f", "file", fileInfo)
	flag.Parse()
	commands := initConf(file)
	execCommand(commands, num)
}

//initConf 初始化配置文件
func initConf(file string) Commands {
	b, err := ioutil.ReadFile(file)
	if err != nil {
		fmt.Println("filePath = [" + file + "] 不存在")
		fmt.Println(err.Error())
		os.Exit(0)
	}
	commands := Commands{}
	json.Unmarshal(b, &commands)
	return commands
}

//listCommand 展示配置了的command
func listCommand(comm Commands) string {
	res := ""
	c := comm.Commands
	for _, v := range c {
		command := v.Command
		for _, arg := range v.Args {
			command += fmt.Sprintf(" %s", arg)
		}
		res += fmt.Sprintf("command id= %d info = %s,command = [ %s ]\n", v.Id, v.Info, command)
	}
	return res
}

// execCommand 执行单个命令
func execCommand(comm Commands, id int64) (status string, err error) {
	var command Command
	for _, v := range comm.Commands {
		if id == v.Id {
			command = v
		}
	}
	var empty Command
	if reflect.DeepEqual(command, empty) {
		fmt.Println("可以执行的命令如下:")
		fmt.Println(listCommand(comm))
		fmt.Printf("Id = [%d] 的命令不存在,请检查配置文件\n", id)
		os.Exit(0)
	}
	conn := command.Command
	args := command.Args
	for _, v := range args {
		conn += fmt.Sprintf(" %s", v)
	}
	// info := command.Info
	cmd := exec.Command("/bin/bash", "-c", conn)
	output, err := cmd.Output()
	if err != nil {
		fmt.Printf("Execute Shell: [ %s ] failed with error: \n%s", conn, err.Error())
		return
	}
	fmt.Printf("Execute Shell: [ %s ] finished with output:\n%s", conn, string(output))
	return "", nil
}
