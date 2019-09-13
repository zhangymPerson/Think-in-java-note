package cn.danao.code.test;

import org.junit.Test;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname ValuePassTest
 * @descriptionclass 1.值传递测试
 * 2.****************
 * @createdate 2019/9/13 8:37
 * @since 1.0
 */
public class ValuePassTest {


    public String name;

    public String test(String str) {
        System.out.println("args" + str);
        str = str + "test method";
        System.out.println("alter args" + str);
        return str;
    }


    public int testInt(int num) {
        System.out.println("args" + num);
        num = num + 1;
        System.out.println("alter args" + num);
        return num;
    }

    public String testInts(int num) {
        System.out.println("args" + num);
        num = num + 1;
        System.out.println("alter args" + num);
        return String.valueOf(num);
    }

    /**
     * 测试值传递
     */
    @Test
    public void testValuePass(){
        System.out.println("start");
        String arg = "ceshi";
        int i = 1;
        System.out.println(test(arg));
        System.out.println(testInt(i));
        System.out.println(testInts(i));
        System.out.println("end");
    }
}
