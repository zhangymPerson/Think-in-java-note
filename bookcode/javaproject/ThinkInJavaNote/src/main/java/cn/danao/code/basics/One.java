package cn.danao.code.basics;

import org.junit.Test;

/**
 * date 2020/4/23 9:58 <br/>
 * descriptionclass <br/>
 * Java基础测试题目
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class One {


    @Test
    public void test() {
        a();
        b();
        c();
        d();
    }

    /**
     * float a = 0.125f; double b = 0.125d; System.out.println((a - b) == 0.0); 代码的输出结果是什么？
     */
    public void a() {
        float a = 0.625f;
        double b = 0.625d;
        System.out.println((a - b) == 0.0);
    }

    /**
     * double c = 0.8; double d = 0.7; double e = 0.6; 那么 c-d 与 d-e 是否相等？
     */
    public void b() {
        double c = 0.8;
        double d = 0.7;
        double e = 0.6;
        System.out.println(c-d);
        System.out.println(d-e);
        System.out.println((c-d) == (d-e));
    }

    /**
     * System.out.println(1.0 / 0); 的结果是什么？
     */
    public void c() {
        System.out.println(1.0 / 0);
    }

    /**
     * System.out.println(0.0 / 0.0); 的结果是什么？
     */
    public void d() {
        System.out.println(0.0 / 0.0);
    }

    /**
     * >> 和 >>> 的区别是？
     */
    public void e() {

    }

    /**
     * 某个类有两个重载方法：void f(String s) 和 void f(Integer i)，那么 f(null) 的会调用哪个方法？
     */
    public void f() {

    }


    /**
     * 某个类有两个重载方法：void g(double d) 和 void g(Integer i)，那么 g(1) 的会调用哪个方法？
     */
    public void g() {

    }

    /**
     * String a = null; switch(a) 匹配 case 中的哪一项？
     */
    public void h() {

    }

    /**
     * <String, T, Alibaba> String get(String string, T t) { return string; } 此方法：
     */
    public void i() {

    }

    /**
     * HashMap 初始容量 10000 即 new HashMap(10000)，当往里 put 10000 个元素时，需要 resize 几次？
     */
    public void j() {

    }
}
