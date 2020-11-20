package cn.danao.main.base.bean

//data类
//创建 DTOs（POJOs/POCOs）
//所有属性的 getters
//（对于 var 定义的还有 setters） equals() hashCode() toString() copy()
// 所有属性的 component1() 、component2() ……等等（参⻅数据类）
data class DataBean(val name: String, val email: String)


//编译器⾃动从主构造函数中声明的所有属性导出以下成员：
// equals() / hashCode() 对； toString() 格式是 "User(name=John, age=42)" ；
// componentN() 函数 按声明顺序对应于所有属性；
//主构造函数需要⾄少有⼀个参数； 主构造函数的所有参数需要标记为 val 或 var ；
//数据类不能是抽象、开放、密封或者内部的；
data class DataUser(val name: String, val age: Int)

//在 toString() 、equals() 、hashCode() 以及 copy() 的实现中只会⽤到 name 属性，
// 并且只有⼀个 component 函数 component1() 。虽然两个 Person 对象可以有不同的年龄，但它们会视为相等。
data class DataPerson(val name: String) {
    var age: Int = 0
}

fun main() {
    var dataBean = DataBean("name", "email@163.com")
    println("$dataBean")

    var p1 = DataPerson("张三")
    p1.age = 12
    var p2 = DataPerson("张三")
    var copyPerson = p2.copy()
    p2.age = 22
    //true
    println("${p1 == p2},${p1 == copyPerson}")

    //copy
    val jack = DataUser(name = "Jack", age = 1)
    val copyJack = jack.copy(age = 2)
    println("$jack -> $copyJack")
}