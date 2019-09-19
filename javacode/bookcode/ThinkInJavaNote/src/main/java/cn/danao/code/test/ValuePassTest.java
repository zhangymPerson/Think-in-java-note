package cn.danao.code.test;

import cn.danao.bean.Person;
import org.junit.Test;

/**
 * @author <a href="mailto:zhangyanmingjiayoiu@163.com">Thinkpad</a>
 * @version 1.0
 * @classname ValuePassTest
 * @descriptionclass 1.鍊间紶閫掓祴璇�
 * 2.****************
 * @createdate 2019/9/13 8:37
 * @since 1.0
 */
public class ValuePassTest {



    public String name;

    public String test(String str) {
        System.out.println("args = " + str);
        str = str + "test method";
        System.out.println("alter args= " + str);
        return str;
    }


    public int testInt(int num) {
        System.out.println("args = " + num);
        num = num + 1;
        System.out.println("alter args = " + num);
        return num;
    }

    public String testInts(int num) {
        System.out.println("args = " + num);
        num = num + 1;
        System.out.println("alter args = " + num);
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

        Person person = new Person();
        person.setName("创建名");
        System.out.println(person.hashCode());
        alterPersonNameFinal(person);
        System.out.println(person.hashCode());


        Person persons = new Person();
        persons.setName("创建名");
        alterPersonNameNoFinal(persons);
        System.out.println(persons.hashCode());

        System.out.println("end");
    }


    public Person alterPersonNameNoFinal(Person person){
        person.setName("修改名 no final");
        return person;
    }

    public Person alterPersonNameFinal(final Person person){
        person.setName("修改名 final");
        return person;
    }

}
