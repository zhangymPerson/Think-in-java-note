# shhelp 命令行帮助工具

## 小工具说明

- 工作中常用的 shell 命令可以配置进来，然后将此程序加入到 Path 中,即可执行对应的命令

- 配置文件格式
  json 文件 格式如下

  ```json
  {
    "commands": [
      {
        "id": 1,
        "command": "ls",
        "args": ["-la"],
        "info": "查看命令"
      },
      {
        "id": 2,
        "command": "go",
        "args": ["version"],
        "info": "查看go版本"
      }
    ]
  }
  ```

- 使用方式

  go run /*.go -f /youpath/command.json -id 1

- 执行结果

  ```shell
  total 2
  drwxr-xr-x   11 user  staff    352  9 17 20:02 .
  drwxr-xr-x    5 user  staff    160  9 18 11:24 ..
  ```

## 项目初始化

- 初始化

  `go mod init shhelp`

- 编写代码

- 构建方式

  `go build -o shhelp`

  然后配置到 PATH 下
