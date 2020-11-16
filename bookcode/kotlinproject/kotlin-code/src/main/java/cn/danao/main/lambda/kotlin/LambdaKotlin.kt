package cn.danao.main.lambda.kotlin

import org.junit.jupiter.api.Test

var funName = fun(a: Int, b: Int): Int {
    println("定义一个函数的变量a=${a},b=${b}")
    return a + b
}

fun lambdaOne(a: Int, b: Int, funArg: (Int, Int) -> Int): Unit {
    println("调用的函数是${funArg}")
    var x = funArg(a, b)
    println("a=${a},b=${b},执行后:x=${x}")
}


@Test
fun test() {
    var a = 5
    var b = 5
    lambdaOne(a, b, funName)
    lambdaOne(a, b) { x, y ->
        println("调用lambda表达式:x=${x},y=${y}")
        x * y
    }
}