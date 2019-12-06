package cn.danao.code.one;

/**
 * description class
 * 1.面向对象
 * create date 2019/7/17 21:16
 *
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @since 1.0
 */
public class ObjectStart {
    /**
     * Java语言必须用main()方法启动
     * Java是先编译 -> 在解释的语言 javac ***.java java ***.class
     *
     * @param args 启动程序可传入的参数
     */
    public static void main(String[] args) {
        //利用无参构造方法构造一个对象
        Person person = new Person();
        Person person1 = new Person("1001", "姓名", "备注", 12);
        //调用方法
        person.setAge(12);
        System.out.println(person);
        System.out.println(person1);
    }
}
