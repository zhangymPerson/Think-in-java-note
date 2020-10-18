package cn.danao.main

import cn.danao.main.base.ServerImpl
import cn.danao.main.base.ServerImplOne

//主函数
fun main() {
    var info = "App.kt"
    println("kotlin main() -  混编代码")

    //直接 ClassName() 就可以构造一个对象 不用 new
    var server = ServerImpl()
    server.print("类:[$info].请求")
    server.print("测试参数1", "测试参数2")
    var thread = Thread({ println("线程函数") })
    server.doWork("thread", thread)


    var serverImplOne = ServerImplOne()
    serverImplOne.print("$info")
    serverImplOne.print("测试参数1", "测试参数2")
}

//普通函数
fun test(): String {
    for (i in 1..10) {
        println(i)
    }
    return "test"
}