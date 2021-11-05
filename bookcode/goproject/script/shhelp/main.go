package main

import (
    "fmt"
    "log"
    "os"
    "shhelp/server"

    "github.com/urfave/cli/v2"
)

// main 程序入口
func main() {
    //封装错误信息。不暴露
    defer func() {
        if err := recover(); err != nil {
            fmt.Println("error:", err)
        }
    }()
    app := &cli.App{
        Name:  "shhelp",
        Usage: "日常开发命令行助手,version : " + GetVersion(),
    }
    app.Flags = initFlag()
    app.Commands = initCommand()
    app.Action = Run
    err := app.Run(os.Args)
    if err != nil {
        fmt.Println("执行错误，错误信息", err)
        os.Exit(1)
        // log.Fatal(err)
    }
}

// 解析参数
func Run(c *cli.Context) error {

    version := c.Bool("version")
    if version {
        fmt.Printf("shhelp的版本是 %s", GetVersion())
        os.Exit(0)
    }

    list := c.Bool("list")
    if list {
        res := server.ListCommand(server.GetCommands())
        fmt.Println(res)
        os.Exit(0)
    }

    add := c.String("append")
    if "" != add {
        log.Println("append = ", add)
        info := c.String("info")
        server.AddCommand(add, info)
        os.Exit(0)
    }

    delId := c.Int("delete")
    if 0 != delId {
        server.DeleteCommand(delId)
        os.Exit(0)
    }

    exec := c.String("exec")
    if "" != exec {
        server.ExecComm(exec)
        os.Exit(0)
    }

    id := c.Int("id")
    if id != 0 {
        log.Println("执行的命令是id=", id)
        server.ExecCommandFromId(id)
        os.Exit(0)
    }

    fmt.Println("请输入 -h 查看命令帮助")
    return nil
}

func initFlag() []cli.Flag {
    //参数设置
    flags := []cli.Flag{
        &cli.StringFlag{
            Name:    "exec",
            Aliases: []string{"e"},
            Value:   "",
            Usage:   "要执行的具体命令 如: --exec 'ls -al' or -e 'ls -al'",
            // Required: true,
        },
        &cli.StringFlag{
            Name:    "append",
            Aliases: []string{"a"},
            Value:   "",
            Usage:   "要添加的命令",
        },
        &cli.StringFlag{
            Name:    "info",
            Aliases: []string{"o"},
            Value:   "",
            Usage:   "要添加的命令说明信息",
        },
        &cli.IntFlag{
            Name:    "id",
            Aliases: []string{"i"},
            Usage:   "要执行的命令id",
        },
        &cli.BoolFlag{
            Name:        "list",
            Aliases:     []string{"l"},
            Usage:       "已经添加的命令集合",
            DefaultText: "false",
        },
        &cli.IntFlag{
            Name:    "delete",
            Aliases: []string{"d"},
            Usage:   "要删除的命令",
        },
        &cli.BoolFlag{
            Name:    "version",
            Aliases: []string{"v"},
            Usage:   "shhelp版本",
        },
    }
    return flags
}

func initCommand() []*cli.Command {
    commamds := []*cli.Command{
        &cli.Command{
            Name:        "all",
            Aliases:     []string{},
            Usage:       "获取所有可以执行的命令",
            UsageText:   "",
            Description: "",
            ArgsUsage:   "[command]",
            Category:    "",
            Action: func(c *cli.Context) error {
                args := c.Args()
                if args.Present() {
                    fmt.Println("has all")
                } else {
                    fmt.Println("no has all")
                }
                return nil
            },
        },
    }
    return commamds
}
