package cn.danao.code.two;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname EveryThingIsObject
 * @descriptionclass
 * 1.第二章
 * 一切皆对象
 * @createdate 2019/7/17 21:16
 * @since 1.0
 */
public class EveryThingIsObject {

    /**
     * 作用域是当前类对象
     *
     */
    private String defaultValue = "defalutValue";
    private static String defaultStaticValue = "defalutValue";

    public static void main(String[] args) {
        System.out.println("第二章:一切皆对象");
        //报错，静态方法不能调用非静态成员属性
        //System.out.println(defaultValue);
        //可以调用静态成员属性
        System.out.println(defaultStaticValue);
    }

    /**
     *
     */
    public static void run(){
        //报错,不能使用 private
        //private String str = "";
        //属于局部变量，作用域在当前方法/函数体中，
        String str = "test";
        int i = 1;
        System.out.println("");
    }

    /**
     * 方法/函数
     *
     *  名称 - 参数 - 返回值 - 方法体
     *
     *  名称：getDefaultValue
     *  参数：String args (括号中的部分)
     *  返回值 String
     *  方法体 {}中的内容
     *  **Java中的方法只能作为类的一部分来创建，方法只能通过对象才能被调用 （静态方法另作说明）**
     *
     * @param args
     * @return
     */
    public String getDefaultValue(String args){
        return args;
    }

}
