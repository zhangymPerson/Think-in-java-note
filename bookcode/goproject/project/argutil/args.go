package argutil

import (
	"flag"
	"log"
)

// 定义几个变量，用于接收命令行的参数值
var (
	user     string
	password string
	host     string
	port     int
	h        bool
	s        *string
	t        string
	f        string
)

func init() {
	// &user 就是接收命令行中输入 -u 后面的参数值，其他同理
	flag.StringVar(&user, "u", "root", "账号，默认为root")
	flag.StringVar(&password, "p", "", "密码，默认为空")
	flag.StringVar(&host, "h", "localhost", "主机名，默认为localhost")
	flag.IntVar(&port, "P", 3306, "端口号，默认为3306")
	flag.BoolVar(&h, "help", false, "帮助文档")
	// 另一种绑定方式
	s = flag.String("s", "赋值方式1", "变量解释")
	// 注意 `signal`。默认是 -s string，有了 `signal` 之后，变为 -s signal
	flag.StringVar(&t, "t", "赋值方式2", "变量解释")
	flag.StringVar(&f, "f", "", "配置文件")
	// 改变默认的 Usage
	//flag.Usage = usage

}

//测试go中获取命令行输入参数的
func Args() {
	// 解析命令行参数写入注册的flag里
	flag.Parse()
	//打印命令行的内容
	if h {
		flag.Usage()
	}
	if "" != f {
		log.Println("配置文件是", f)
	} else {
		log.Println("需要输入配置文件")
	}
	// 输出结果
	//fmt.Printf("user：%v\npassword：%v\nhost：%v\nport：%v\n", user, password, host, port)
}
