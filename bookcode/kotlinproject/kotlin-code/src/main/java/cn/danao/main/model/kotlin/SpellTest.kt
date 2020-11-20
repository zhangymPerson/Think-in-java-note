package cn.danao.main.model.kotlin

import cn.danao.main.model.bean.OneModel

fun main() {
    var init = OneModel.init()
    spell(null)
    spell(OneModel())
    spell(init)
}


fun spell(oneModel: OneModel?) {
    var stringBuffer = StringBuffer()
    stringBuffer.append(oneModel?.getId() ?: "").append(oneModel?.name ?: "")
    println("str = $stringBuffer")
    oneModel?.strs?.forEach { stringBuffer.append("oneModel的strs,$it") }
    oneModel?.twoModels?.forEach {
        it?.threeModels?.forEach { three ->
            three?.strs?.forEach { strs ->
                stringBuffer.append("threemodel中的strs$strs")
            }
        }
    }
    println("str = $stringBuffer")
    println("end")
}