// 声明 main 包
// 当前程序的包名
package main

// 导入其他包
import (
	"fmt"
	log "github.com/cihub/seelog"
	"runtime"
)

// 常量定义
const PI = 3.14

// 全局变量的声明和赋s值
var name = "gopher"

// 一般类型声明
type newType int

// 结构的声明
type gopher struct{}

// 接口的声明
type golang interface{}

//函数 a b, return a+b
func Sum(a, b int) int { return a + b }


// 由main函数作为程序入口点启动
func main() {
	fmt.Println("Hello World!")
	defer log.Flush()
    log.Info("Hello from Seelog!")
    //定义变量
    var a int = 2
    var b int = 3
    log.Info(Sum(a,b))
	//go版本
	log.Info(runtime.Version())
}
