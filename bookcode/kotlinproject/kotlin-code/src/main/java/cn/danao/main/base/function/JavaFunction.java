package cn.danao.main.base.function;

/**
 * date 2020/11/20 10:22 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class JavaFunction {
    /**
     * main方法
     *
     * @param args
     */
    public static void main(String[] args) {
        //kotlin全局函数 未被类包裹的函数
        KotlinFunctionKt.one("test");
        //kotlin中类中的普通函数
        KotlinFunction kotlinFunction = new KotlinFunction();
        kotlinFunction.kotlinOne();
        //不能访问伴生对象的非注解方法
        // kotlinFunction.sayHello("zhangsan")
        //kotlin中的伴生对象中的注解函数 类比java中的静态方法
        KotlinFunction.sayHello();
        int filed = KotlinFunction.filed;
        System.out.println(filed);
    }

    /**
     * 普通 方法
     *
     * @param arg
     */
    public void test(String arg) {
        System.out.println(arg);
    }

    /**
     * 静态 方法
     *
     * @param arg
     */
    public static void testStatic(String arg) {
        System.out.println(arg);
    }
}
