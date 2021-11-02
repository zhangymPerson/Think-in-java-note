package server

import (
    "encoding/json"
    "fmt"
    "io/ioutil"
    "log"
    "os"
    "os/exec"
    "reflect"
)

var defaultConfFile = ".shhelp.json"
var file = Home() + "/" + defaultConfFile

var commamds Commands

func init() {
    // 初始化配置文件
    initConf()
    commamds = GetCommands()
}

// Command command参数
type Command struct {
    Id      int      `json:"id"`
    Command string   `json:"command"`
    Args    []string `json:"args"`
    Info    string   `json:"info"`
}

// Commands 集合
type Commands struct {
    Commands []Command `json:"commands"`
}

//initConf 初始化配置文件
func initConf() {
    // 文件是否存在判断
    _, err := os.Stat(file)
    if err != nil {
        log.Printf("[%s] 文件不存在", file)
        //没有则创建
        _, error := os.Create(file)
        if error != nil {
            log.Println("创建配置文件失败", error.Error())
        }
    }
}

// 获取所有commands
func GetCommands() Commands {
    b, err := ioutil.ReadFile(file)
    if err != nil {
        log.Println("filePath = [" + file + "] 不存在")
        log.Println(err.Error())
    }
    commands := Commands{}
    json.Unmarshal(b, &commands)
    return commands
}

//添加command
func AddCommand(comm string) {
    command := Command{
        Command: comm,
    }
    // 去重
    if len(commamds.Commands) == 0 {
        command.Id = 1
        commamds.Commands = append(commamds.Commands, command)
    } else {
        var bool = false
        for _, v := range commamds.Commands {
            if v.Command == comm {
                bool = true
            }
        }
        if !bool {
            command.Id = maxId() + 1
            commamds.Commands = append(commamds.Commands, command)
        }
    }
    data, _ := json.Marshal(commamds)
    ioutil.WriteFile(file, data, 066)
}

//listCommand 展示配置了的command
func ListCommand(comm Commands) string {
    res := ""
    c := comm.Commands
    for _, v := range c {
        command := v.Command
        for _, arg := range v.Args {
            command += fmt.Sprintf(" %s", arg)
        }
        res += fmt.Sprintf("command id= %d info = %s,command = [%s]\n", v.Id, v.Info, command)
    }
    return res
}

// execCommand 执行单个命令
func ExecCommand(comm Commands, id int) (status string, err error) {
    var command Command
    for _, v := range comm.Commands {
        if id == v.Id {
            command = v
        }
    }
    var empty Command
    if reflect.DeepEqual(command, empty) {
        log.Println("可以执行的命令如下:")
        log.Println(ListCommand(comm))
        log.Printf("Id = [%d] 的命令不存在,请检查配置文件\n", id)
        os.Exit(0)
    }
    conn := command.Command
    return ExecComm(conn)
}

//执行命令
func ExecComm(command string) (string, error) {
    // info := command.Info
    cmd := exec.Command("/bin/bash", "-c", command)
    output, err := cmd.Output()
    if err != nil {
        log.Printf("Execute Shell: [ %s ] failed with error:\n%s", command, err)
        return err.Error(), nil
    }
    log.Printf("执行命令: [ %s ] 执行结果:\n %s", command, string(output))
    return "", nil
}

//根据id执行命令
func ExecCommandFromId(id int) {
    for _, c := range commamds.Commands {
        if c.Id == id {
            ExecComm(c.Command)
            return
        }
    }
    log.Printf("没找到id=[%d]的命令", id)
}

func isExit(comm string) *Command {
    for _, c := range commamds.Commands {
        if c.Command == comm {
            return &c
        }
    }
    return nil
}

//获取最大id
func maxId() int {
    max := 0
    for _, c := range commamds.Commands {
        if c.Id > max {
            max = c.Id
        }
    }
    return max
}
