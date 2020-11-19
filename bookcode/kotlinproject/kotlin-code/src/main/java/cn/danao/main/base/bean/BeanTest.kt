package cn.danao.main.base.bean

import org.junit.Test

class BeanTest {
    //java 对象
    @Test
    fun testOneJavaObj() {
        var personJava = PersonJava()
        //注释掉set则无法调用
//        personJava.argOne = "赋值private"
//        //不建议
//        personJava.setArgOne("可以调用set")
        personJava.argTwo = "赋值public"
        personJava.setArgTwo("可以调用set")
        personJava.argThree = "赋值默认"
        personJava.setArgThree("可以调用set")
        println("$personJava")

        //有构造函数的可以使用这种赋值方式
        var construction = PersonJava("构造参数1", "构造参数2", "构造参数3")
        println("$construction")
    }

    @Test
    fun testKotlinObj() {
        var personKotlin = PersonKotlin("name", 12, "argOne", "argTwo")
        println("$personKotlin")
        //val 变量只能初始化一次，不能被修改
//        personKotlin.argOne = "22"
        personKotlin.age=12


    }
}