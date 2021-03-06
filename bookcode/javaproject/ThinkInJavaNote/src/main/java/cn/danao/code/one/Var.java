package cn.danao.code.one;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/1/4 10:10 <br/>
 * descriptionclass <br/>
 * Java中声明变量
 *
 * @author Thinkpad
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class Var {

    /**
     * 类变量
     */
    static int allClicks = 0;

    /**
     * 实例变量
     */
    String str = "hello world";

    /**
     * 主函数
     *
     * @param args 参数
     */
    public static void main(String[] args) {
        System.out.println("变量声明");
        // 声明三个int型整数：a、 b、c
        int a, b, c;
        // 声明三个整数并赋予初值
        int d = 3, e = 4, f = 5;
        // 声明并初始化 z
        byte z = 22;
        // 声明并初始化字符串 s
        String s = "runoob";
        // 声明了双精度浮点型变量 pi
        double pi = 3.14159;
        // 声明变量 x 的值是字符 'x'。
        char x = 'x';

        Person p = new Person("p", "p", "p", 32);
        Person pp = p;
        //修改的是同一个对象 引用传递  go中的结构体是值拷贝
        pp.setName("pp");
        log.info("\np {} \npp {}", p, pp);
    }

    public void method() {
        // 局部变量
        int i = 0;
    }
}
