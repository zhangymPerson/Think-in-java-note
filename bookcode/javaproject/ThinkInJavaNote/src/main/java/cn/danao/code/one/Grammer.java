package cn.danao.code.one;

import java.util.ArrayList;
import java.util.List;

/**
 * date 2020/1/4 9:43 <br/>
 * description class <br/>
 * Java中的常用语法
 *
 * @author Thinkpad
 * @version 1.0
 * @since 1.0
 */
public class Grammer {

    /**
     * 主程序入口
     *
     * @param args 程序启动传参
     */
    public static void main(String[] args) {
        one();
        two();
        three();
    }

    //静态代码块
    static {
        System.out.println("static code");
    }

    /**
     * 循环语句
     */
    public static void one() {
        //基本for循环
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
        }
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //foreach循环写法
        for (String s : list) {
            System.out.println(s);
        }
        //集合提供的函数式编程写法
        list.forEach(s -> System.out.println(s));
        //while循环
        boolean flag = true;
        int i = 0;
        while (flag) {
            if (i < 10) {
                i++;
                System.out.println(i);
            } else {
                flag = false;
            }
        }
        //do-while循环
        //do…while 循环至少会执行一次
        int x = 10;
        do {
            System.out.print("value of x : " + x);
            x++;
            System.out.print("\n");
        } while (x < 20);
    }

    /**
     * 判断语句
     */
    public static void two() {
        int a = 10;
        //if-else
        if (a > 0) {
            System.out.println("a>0");
        } else {
            System.out.println("a<=0");
        }
        //if -else if - else
        if (a > 0) {
            System.out.println("a > 0");
        } else if (a < 0) {
            System.out.println("a < 0");
        } else {
            System.out.println("a = 0");
        }
        //多层if
        int x = 30;
        int y = 10;
        if (x == 30) {
            if (y == 10) {
                System.out.print("X = 30 and Y = 10");
            }
        }
    }


    /**
     * switch语句
     */
    public static void three() {
        System.out.println("switch语句");
        int i = 10;
        switch (i) {
            case 1:
                //语句
                System.out.println("i = 1");
                //可选
                break;
            case 10:
                //语句
                System.out.println("i = 10");
                //可选
                break;
            //你可以有任意数量的case语句
            //可选
            default:
                //语句
                System.out.println("i = " + i);
        }
    }
}
