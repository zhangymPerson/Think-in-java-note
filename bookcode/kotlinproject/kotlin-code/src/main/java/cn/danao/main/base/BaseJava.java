package cn.danao.main.base;

import kotlin.text.StringsKt;

public class BaseJava {

    public void test() {
        //调用kotlin中的工具类
        Integer integer = StringsKt.toIntOrNull("23");


    }
}
