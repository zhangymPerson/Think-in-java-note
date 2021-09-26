package server

import "fmt"

//type Args 脚本使用的参数
type Args struct {
	//文件
	File string
	//文件夹
	Dir string
	//分隔符
	Split string
	//执行的命令
	Exec string
}

func (args *Args) String() string {
	res := fmt.Sprintf("监控的文件夹是:[%v],监控的文件是[%v],内容分割符是[%v],后续执行的command是[%v]", args.Dir, args.File, args.Split, args.Exec)
	return res
}
