package cn.danao.main.base

import cn.danao.main.base.bean.Person
import org.junit.Test
import kotlin.random.Random

class BaseType {
    //基本类型
    fun testOne() {
        // 可以使⽤字⾯值后缀定义⽆符号类型：
        val uint = 42u
        val ulong = 42uL
        val ubyte: UByte = 255u
        // 通过标准库扩展可以将有符号类型转换为⽆符号类型，反之亦然：
        val int = uint.toInt()
        val byte = ubyte.toByte()
        val ulong2 = byte.toULong()
        // ⽆符号类型⽀持类似的操作符：
        val x = 20u + 22u
        val y = 1u shl 8
        val z = "128".toUByte()
        val range = 1u..5u
        println("uint=${uint},ulong=${ulong},ubyte=${ubyte},int=${int},byte=${byte},ulong2=${ulong2},x=${x},y=${y},z=${z},${range}")
    }

    /**
     * 随机数
     */
    fun testTwo() {
        for (i in 0..100) {
            var random = Random.nextInt(0, 255)
            var randomTwo = java.util.Random().nextInt(255)
            println("${random}  ${randomTwo}")
        }

    }

    fun str() {
        var s: String = ""
        var toInt = s?.toIntOrNull() ?: 0
        s?.ifBlank { print("aaa") }
        println("s=${s} toInt = ${toInt}")
    }

    /**
     * 类型检测与类型转换
     * is !is
     * as
     */
    @Test
    fun typeTest() {
        var person: Any = Person("", 10)
        //不确定类型可以用is ,确定类型不能用is
        if (person is String) {
            println("${person} 是字符串")
        } else {
            println("${person} 不是字符串")
        }
        //安全的类型转换  as?
        var strC = person as? String
        println("${strC}")
        //不安全的类型转换
        var str: String = person as String
        println("${str}")
        var strA = person as String
        var strB = person as String?
    }

    @Test
    fun equalsTest() {
        var p = Person("张三", 15)
        var p1 = Person("张三", 15)
        println("p==p1 -> ${p == p1}")
    }
}


//fun main() {
//    var baseType = BaseType()
//    baseType.testOne()
//    baseType.testTwo()
//    baseType.str()
//}