package cn.danao.learning.lambda;

import cn.danao.learning.lambda.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * date 2020/4/6 8:39 <br/>
 * descriptionclass <br/>
 * 集合的lambda表达式测试
 * <p>
 * <p>
 * 1.四种接口 函数式编程接口
 * <p>
 * Consumer<T> : 消费型接口 无返回
 * <p>
 * void accept(T t);
 * <p>
 * Supplier<T> 供给型接口
 * <p>
 * T get();
 * <p>
 * FUnction<T,R> 函数型接口</>
 * <p>
 * R apply(T)
 * <p>
 * Predicate<T> 断言型的接口
 * <p>
 * boolean test(T t)
 * <p>
 * </>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class CollectionLambda {


    List<Person> list = Arrays.asList(new Person[]{
            new Person("1001", "张三", 12),
            new Person("1002", "李四", 21),
            new Person("1003", "王麻子", 23),
            new Person("1004", "西门吹雪", 23),
            new Person("1005", "你猜", 23),
            new Person("1006", "我是谁", 23),
            new Person("1007", "你是谁", 23),
            new Person("1008", "他是谁", 23)

    });

    @Test
    public void test() {
        //调用传值
        list.forEach(k -> System.out.println(k));
        //调用静态方法  不需要 参数列表
        list.forEach(System.out::println);
        log.info("-----------------------------------------------------------");
        //消费型函数式编程
        changeStr("张三", s -> System.out.println(s + "你好"));
        changeStr("张三", s -> System.out.println(s + "早上好"));
        changeStr("张三", s -> System.out.println(s + "中午好"));
        changeStr("张三", s -> System.out.println(s + "下午好"));
        log.info("-----------------------------------------------------------");
        //供给型函数式编程
        Person p = getPerson(() -> new Person("10001", "供给型用户", 34));
        log.info("{}", p);
        log.info("-----------------------------------------------------------");
        for (int i = 0; i < 3; i++) {
            Person person = getPersonFromName((key)->{
                return new Person(key,"批量用户",25);
            });
            log.info("{}",person);
        }
        log.info("-----------------------------------------------------------");
    }


    /**
     * 编写消费型的测试方法
     *
     * @param s        字符
     * @param consumer 测试函数式编程的接口
     */
    void changeStr(String s, Consumer<String> consumer) {
        if (Objects.nonNull(s)) {
            consumer.accept(s);
        }
    }

    /**
     * 编写供给型接口
     *
     * @param supplier
     * @return
     */
    Person getPerson(Supplier<Person> supplier) {
        return supplier.get();
    }

    Person getPersonFromName(Function<String, Person> function) {
        Random random = new Random();
        return function.apply("批量创建用户" + random.nextInt(100));
    }

}
