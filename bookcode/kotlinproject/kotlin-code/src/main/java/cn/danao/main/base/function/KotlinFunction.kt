package cn.danao.main.base.function


//=======================================全局函数======================================================
//以下类都是全局函数
//不被类包围
fun one() {
    println("kotlin中全局函数 fun one()")
}

//无返回值
//不在类中的函数算包下面的全局函数
//kt中直接调用
//Java 中文件名+kt.funName调用
fun one(arg: String): Unit {
    println("fun one() arg=$arg")
}

//有返回值
fun one(arg: String, argTwo: String): String {
    println("fun one() arg=$arg,argTwo=$argTwo")
    return arg
}


//=======================================普通类中的的方法======================================================
class KotlinFunction {
    companion object {
        // java类中的 public static int filed = 42;
        @JvmField
        val filed: Int = 42

        var filedTwo: Int = 10

        // java类中的 public static void sayHello(){}
        @JvmStatic
        fun sayHello() {
            println("Hello, world!")
        }

        fun sayHello(name: String?) {
            println("hello $name")
        }
    }

    fun kotlinOne() {
        println("kotlin中的类中的普通函数")
    }

    fun kotlinTwo(arg: String): String {
        println("带参数 arg = $arg")
        return "返回值"
    }


}

fun kotlinClassTest() {
    //kotlin可以访问非 @JvmField 和 @JvmStatic注解的对象
    //java 不能访问非注解属性和方法
    println("filed=${KotlinFunction.filed}")
    println("filedTwo=${KotlinFunction.filedTwo}")
    println("sayHello()=${KotlinFunction.sayHello()}")
    println("sayHello(test)=${KotlinFunction.sayHello("test")}")
}

//=======================================函数作为参数的的函数(lambda表达式)======================================================

//如果在默认参数之后的最后⼀个参数是 lambda 表达式，
// 那么它既可以作为具名参数在括号内传⼊，也可以在括号 外传⼊：
fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /*……*/
}

fun fooTest() {
    // 使⽤默认值 baz = 1
    foo(1) { println("hello") }
    // 使⽤两个默认值 bar = 0 与 baz = 1
    // qux= {} 这个属于具名函数 函数参数多的时候可以使用.
    // 对于 JVM 平台：在调⽤ Java 函数时不能使⽤具名参数语法，因为 Java 字节码并不总是保留函数参数的名称。
    foo(qux = { println("hello") })
    foo { println("hello") }
}

//=======================================具名参数======================================================
fun reformat(str: String, normalizeCase: Boolean = true, upperCaseFirstLetter: Boolean = true, divideByCamelHumps: Boolean = false, wordSeparator: Char = ' ') { /*……*/
}

fun reformatTest() {

    //我们可以使⽤默认参数来调⽤它：
    var str = ""
    reformat(str)
    //然⽽，当使⽤⾮默认参数调⽤它时，该调⽤看起来就像： reformat(str, true, true, false, '_')
    // 使⽤具名参数我们可以使代码更具有可读性：
    reformat(str, normalizeCase = true, upperCaseFirstLetter = true, divideByCamelHumps = false, wordSeparator = '_')
    //并且如果我们不需要所有的参数：
    reformat(str, wordSeparator = '_')
}

fun printHello(name: String?): Unit {
    if (name != null) {
        println("Hello $name")
    } else {
        println("Hi there!") // `return Unit` 或者 `return` 是可选的 }
    }
}

fun main() {
    println("主函数")
    one()
    //调用java中的函数
    var javaFunction = JavaFunction()
    //创建对象调用普通的方法
    javaFunction.test("arg")
    //类名直接调用static方法
    JavaFunction.testStatic("arg")

    //调用kotlin类中普通函数
    var kotlinFunction = KotlinFunction()
    kotlinFunction.kotlinOne()
    kotlinClassTest()
}

