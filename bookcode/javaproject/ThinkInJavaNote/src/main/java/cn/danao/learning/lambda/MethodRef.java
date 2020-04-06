package cn.danao.learning.lambda;

import cn.danao.learning.lambda.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * date 2020/4/6 9:23 <br/>
 * descriptionclass <br/>
 * lambda表达式中的方法引用
 * <p>
 * 三种表达式
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * <p>
 * 要求 方法和函数式接口中的方法保持一致 (参数列表和返回值)
 *
 * 构造器的使用
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class MethodRef {

    /**
     * 所有lambda表达式中方法引用 引用的方法中的参数列表和返回值类型必须与函数式接口中的抽象方法(函数)保持一致
     */
    @Test
    public void test() {
        //普通
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("test");
        log.info("============================================================");
        //第一种
        // 对象::实例方法名
        PrintStream ps = System.out;
        Consumer<String> consumer1 = ps::println;
        consumer1.accept("one");
        log.info("============================================================");
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
        comparator.compare(1,2);
        Comparator<Integer> comparator1 = Integer::compare;
        System.out.println(comparator1.compare(21,22));
        log.info("============================================================");
        //类::实例方法名
        Consumer<Integer> integerConsumer = System.out::println;
        integerConsumer.accept(3223);
    }

    @Test
    public void testTwo(){
        Person pp = new Person();
        System.out.println(pp);
        Supplier<Person> p = Person::new;
        Person s = p.get();
        System.out.println(p);
    }
}
