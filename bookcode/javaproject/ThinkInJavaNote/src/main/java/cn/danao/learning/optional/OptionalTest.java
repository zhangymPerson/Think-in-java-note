package cn.danao.learning.optional;

import cn.danao.learning.lambda.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * date 2020/4/8 16:10 <br/>
 * descriptionclass <br/>
 * optional的使用
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OptionalTest {

    @Test
    public void test() {
        log.info("optional的测试");
        Optional<Person> optionalPerson = Optional.of(new Person());
        for (int i = 0; i < 10; i++) {
            Optional<Person> person = getPerson();
            //过滤 年龄大于50的 且只要年龄字段
            //person.filter(k -> k.getAge() > 50).map(Person::getAge).ifPresent(System.out::println);
            person.ifPresent(Person::toString);
        }

    }

    public boolean ttt(Person k) {
        if (k.getAge() > 50) {
            return true;
        } else {
            return false;
        }
    }

    public Optional<Person> getPerson() {
        //调用工厂方法创建Optional实例
        Optional<String> name = Optional.of("Dolores");
        //创建一个空实例
        Optional empty = Optional.ofNullable(null);
        //创建一个不允许值为空的空实例
        Optional noEmpty = Optional.of("nonull");
        //报空指针异常
        //Optional Empty = Optional.of(null);

        //如果值不为null，orElse方法返回Optional实例的值。
        //如果为null，返回传入的消息。
        //输出：Dolores
//        System.out.println(name.orElse("There is some value!"));
//        //输出：There is no value present!
//        System.out.println(empty.orElse("There is no value present!"));
//        //抛NullPointerException
//        System.out.println(noEmpty.orElse("There is no value present !"));

        List<Person> list = Arrays.asList(
                new Person("1001", "张三1", 23),
                new Person("1002", "张三2", 33),
                new Person("1003", "张三3", 43),
                new Person("1004", "张三4", 53),
                new Person("1005", "张三5", 63),
                new Person("1006", "张三6", 73),
                new Person("1007", "张三7", 83),
                new Person("1008", "张三8", 93)
        );

        Random random = new Random();
        int i = random.nextInt(7);
        return Optional.of(list.get(i));
    }
}
