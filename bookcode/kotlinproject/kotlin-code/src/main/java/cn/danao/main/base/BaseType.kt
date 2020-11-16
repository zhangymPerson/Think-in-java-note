package cn.danao.main.base

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

}



fun main() {
//    BaseType().testOne()
//    BaseType().testTwo()
    BaseType().str()
}