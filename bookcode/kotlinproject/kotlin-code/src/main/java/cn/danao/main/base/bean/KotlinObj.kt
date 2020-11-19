package cn.danao.main.base.bean

//跟在类名后面的是主构造函数
//类里面用  constructor 修饰的是次构造函数

//在 Kotlin 中的⼀个类可以有⼀个主构造函数以及⼀个或多个次构造函数。主构造函数是类头的⼀部分：它跟在类名 （与可选的类型参数）后。
class PersonKotlinObj constructor(firstName: String) { /*……*/ }

class CustomerKotlinObj(name: String) {
    val customerKey = name.toUpperCase()
}

//主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

//类也可以声明前缀有 constructor的次构造函数：
class PersonConstructor {
    var children: MutableList<PersonConstructor> = mutableListOf<PersonConstructor>()

    constructor(parent: PersonConstructor) {
        parent.children.add(this)
    }
}

//如果类有⼀个主构造函数，每个次构造函数需要委托给主构造函数，
// 可以直接委托或者通过别的次构造函数间接委托。委托到同⼀个类的另⼀个构造函数⽤ this 关键字即可：
class PersonWeiTuo(val name: String) {
    var children: MutableList<PersonWeiTuo> = mutableListOf()

    constructor(name: String, parent: PersonWeiTuo) : this(name) {
        parent.children.add(this)
    }
}

// 请注意，初始化块中的代码实际上会成为主构造函数的⼀部分。委托给主构造函数会作为次构造函数的第⼀条语句，
// 因此所有初始化块与属性初始化器中的代码都会在次构造函数体之前执⾏。
// 即使该类没有主构造函数，这种委托仍会隐 式发⽣，并且仍会执⾏初始化块：
class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

//默认情况下，Kotlin 类是最终（final）的：它们不能被继承。要使⼀个类可继承，请⽤ open 关键字标记它。
// 该类开放继承
//open class Base

// 如需声明⼀个显式的超类型，请在类头中把超类型放到冒号之后：
open class Base(p: Int)
class Derived(p: Int) : Base(p)

//父类
open class Shape {
    //加了open才可以被子类重写
    open fun draw() { /*……*/
    }

    fun fill() { /*……*/
    }
}

//子类重写父类函数 需要加 override 关键字
class Circle() : Shape() {
    override fun draw() { /*……*/
    }
    //override fun fill(){}
}