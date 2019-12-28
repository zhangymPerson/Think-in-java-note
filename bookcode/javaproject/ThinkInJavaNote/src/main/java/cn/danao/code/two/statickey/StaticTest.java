package cn.danao.code.two.statickey;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname StaticTest
 * @descriptionclass 1.****************
 * 2.****************
 * @createdate 2019/7/17 23:32
 * @since 1.0
 */
//类中直接加 static 报错
//public static class StaticTest {
public class StaticTest {

    /**
     * 普通成员属性
     */
    private String string;

    /**
     * static 静态成员属性
     */
    public static String staticStr = "静态属性";

    /**
     * 静态代码块
     */
    static{
        System.out.println("静态代码块执行顺序");
    }


    /**
     * 静态内部类
     */
    static class ClassTest{

    }

    /**
     * static 修饰的方法 可以通过类名直接调用
     * StaticTest.staticMethod();
     * @return
     */
    public static String staticMethod(){
        return "静态测试方法";
    }

}
