package cn.danao.main.base

import jdk.nashorn.internal.runtime.regexp.joni.Config.log

/**
 * 定义一个接口
 */
interface Server {

    /**
     * 默认方法 。子类可以不实现
     */
    fun print(string: String, over: String) {
        println("测试默认实现$string,$over")
    }

    fun print(string: String)
    fun doWork(id: String, thread: Thread): Boolean
}

//实现类的写法
class ServerImpl : Server {

    var info = "实现类Server"
    override fun print(string: String, over: String) {
        println("[$info]:测试默认实现$string,$over")
    }

    override fun print(string: String) {
        println("类[$info]:请求参数[$string]")
    }

    override fun doWork(id: String, thread: Thread): Boolean {
        println("类[$info]:请求参数[$id],[$thread]")
        thread.start()
        return true
    }

}

class ServerImplOne : Server {
    override fun print(string: String) {
//        TODO("Not yet implemented")
        var name = this.javaClass.name
        log.println("子类2=[$name],请求参数[$string]")
    }

    override fun doWork(id: String, thread: Thread): Boolean {
//        TODO("Not yet implemented")
        return false
    }

}
