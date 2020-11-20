package cn.danao.main.base

import cn.danao.main.base.bean.Parent


open class kotlinSon(var sonName: String, var ages: Int) : Parent() {
    override fun toString(): String {
        return "kotlinSon(sonName='$sonName',ages = '$ages',age = '$age',id = '$id')"
    }
}

fun main() {
    var kotlinSon = kotlinSon("test", 23)
    kotlinSon.setId("kotlinSonId")
    kotlinSon.setName("kotlinSonName")
    println(kotlinSon)
}