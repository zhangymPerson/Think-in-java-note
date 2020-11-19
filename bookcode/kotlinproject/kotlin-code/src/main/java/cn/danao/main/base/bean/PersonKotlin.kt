package cn.danao.main.base.bean


//类不加open不能继承
//默认变量无
class PersonKotlin(var name: String, var age: Int, val argOne: String, argTwo: String) {

    override fun toString(): String {
        return "PersonKotlin(name='$name', age=$age, argOne='$argOne')"
    }
}


