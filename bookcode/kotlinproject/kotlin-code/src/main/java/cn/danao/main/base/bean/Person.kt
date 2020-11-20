package cn.danao.main.base.bean

/**
 *創建對象 并且添加get set 方法
 * open 关键字
 * 在java中允许创建任意的子类并重写方法任意的方法，除非显示的使用了final关键字进行标注。
 * 而在kotlin的世界里面则不是这样，在kotlin中它所有的类默认都是final的，那么就意味着不能被继承，
 * 而且在类中所有的方法也是默认是final的，那么就是kotlin的方法默认也不能被重写。那么想在kotlin中继承父类应该怎么做呢？
 * 为类增加open，class就可以被继承了
 */
open class Person(var name: String, var age: Int) {
    var lastName: String = "zhang"
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = 100
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }
    var heiht: Float = 145.4f
        private set

    var weight: Double = 100.01

    var children: MutableList<PersonTwoCon> = ArrayList()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (name != other.name) return false
        if (age != other.age) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }


}

/**
 * 继承
 */
class Son(lastName: String, no: Int) : Person("", 0) {
    override fun toString(): String {
        return "$lastName,$no,$heiht"
    }
}


/**
 * 这种定义方式则构造对象时必须传入相关参数
 */
open class PersonOne(var age: Int, var name: String) {
    //重写toString()
    override fun toString(): String {
        return "age = $age ,name = $name "
    }
}

//主构造器
//主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
class PersonMain constructor(firstName: String) {
    init {
        println("FirstName is $firstName")
    }
}

//次构造函数
//类也可以有二级构造函数，需要加前缀 constructor:
class PersonTwoCon {
    constructor(parent: Person) {
    }
}

// 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。
// 在同一个类中代理另一个构造函数使用 this 关键字：
class PersonOther(val name: String) {
    constructor (name: String, age: Int) : this(name) {
        // 初始化...
    }
}


//如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。
// 构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
class DontCreateMe private constructor() {
}


//在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，
// 这个构造函数会直接使用默认值。这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
class Customer(val customerName: String = "default")

// 测试
fun main(args: Array<String>) {
    var person: Person = Person("", 0)

    person.lastName = "wang"

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

    var children = person.children
    children.add(PersonTwoCon(person))
    println("${person.children}")

    var personOne = PersonOne(1, "zhangsan")
    personOne.age = 10
    println("$personOne,${personOne.age}")


    var customer = Customer()
    println("$customer")

    var son = Son("sonName", 1001)
    son.weight = 32.34f.toDouble()
    println(son)

}