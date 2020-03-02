package cn.danao

class Application {

    // 类似Java中 public static void main(String[] args){}
    //在 此处的函数属于静态函数 可以直接运行
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            for (arg: String in args) {
                println(arg)
            }
            println("测试")
        }
    }

    //属于成员函数  需要创建成员对象调用
    open fun method(a: Int, b: Int): Int {
        return a + b
    }

}

//启动函数要写在类外面
fun main() {
    //定义一个类对象 可以调用成员函数
    val classOne = Application()
    //这个是类对象 只能调用静态函数
    var classObj = Application
    println("hello word")
    classOne.method(1, 2)
    //classObj.method(1,2) 报错
    val args: Array<String> = arrayOf("argsOne", "argsTwo")
    classObj.main(args)
}
