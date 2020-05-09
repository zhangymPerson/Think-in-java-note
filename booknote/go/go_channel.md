# channel

## 管道的基本使用

- Channel的本质是一个队列
- Channel是线程安全的, 也就是自带锁定功能
- Channel声明和初始化

    ```go
    var 变量名称 chan 数据类型
    make(chan 数据类型, 容量)

    //实例
    //创建管道并且实例化管道关键字 chan
	var intChan chan int         = make(chan int, 10)
	var resChan chan map[int]int = make(chan map[int]int, 20)
    ```

    **管道和切片/字典一样,必须创建后才能使用,否则会报错**
    **Channel和切片还有字典一样, 是引用类型,是地址传递**

## 注意事项

- channel可以声明为只读或者只写的管道

    ```go
    //定义一个只写的int管道
    var oneChan chan<- int
    //定义一个string类型的只读管道
    var twoChan <-chan string
    //定义包含任何数据的管道
    var threeChan chan interface{}
    ```

- 使用select可以解决从管道取数据阻塞的问题
