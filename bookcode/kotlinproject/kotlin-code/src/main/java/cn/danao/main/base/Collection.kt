package cn.danao.main.base

//集合
//Kotlin将集合分为只读集合和可变集合。这种区别源自最基础的集合接口：kotlin.collections.Collection。
// 该接口可以对集合进行一些基本操作，但无任何添加和移除元素的方法。
//集合类型	只读	可变
//List	listOf	mutableList、arrayListOf
//Set	setOf	mutableSetOf、hashSetOf、linkedSetOf、sortedSetOf
//Map	mapOf	mutableMapOf、hashMapOf、linkeMapOf、sortedMapOf

fun collection() {
    //不可变
    var listOf = listOf<Int>(12, 13, 14, 22, 22, 2, 22, 3)
    listOf.forEach { i -> print("$i,") }
    println()
    //可变
    var mutableListOf = mutableListOf<Int>(23, 33, 56, 33, 34, 43)
    //增加
    mutableListOf.add(34)
    var info = try {
        var toInt = "45"?.toInt()
        "true"
        33
    } catch (e: Exception) {
        println(e.message)
        23
        "333"
    }
    println(info)
    mutableListOf.add("45"?.toInt())
    //删除匹配到的第一个
    var remove = mutableListOf.remove(33)
    println(remove)
    println(mutableListOf.toString())
}

fun main() {
    collection()

    //try - catch 语法有返回值需要注意o
    val a: Int? = try {
        1 //正常运行,返回1
    } catch (e: NumberFormatException) {
        2
        null
    } finally {
        3 //finally块不会影响表达式结果
    }

    val b: Int? = try {
        1
        throw NumberFormatException()
    } catch (e: NumberFormatException) {
        2
        null //捕获异常,返回null
    } finally {
        3 //finally块不会影响表达式结果
    }

    println(a) //输出1
    println(b) //输出null
}