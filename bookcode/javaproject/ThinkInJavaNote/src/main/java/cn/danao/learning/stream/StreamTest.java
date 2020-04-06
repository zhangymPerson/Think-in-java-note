package cn.danao.learning.stream;

import cn.danao.learning.lambda.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * date 2020/4/6 10:02 <br/>
 * descriptionclass <br/>
 *
 * 流的操作 和普通流不完全一样
 *
 * 操作的步骤
 *
 * 1.创建stream
 * 2.中间操作
 * 3.终止操作
 *
 * 集合类是数据  流是计算过程
 *
 * 1.stream不存储元素
 * 2.stream不会改变原对象
 * 3.stream的操作是延时的， 需要结果的时候才执行
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class StreamTest {

    @Test
    public void test(){
        //1.集合转成流
        List<String>  list = new ArrayList<>();
        //串行流
        Stream<String> stringStream = list.stream();
        //并行流
        Stream<String> stringStream1 = list.parallelStream();

        //2.数组工具转流
        Stream<String> stringStream2 = Arrays.stream(new String[]{"a","b"});

        Stream<String> stringStream3 = Stream.of("2","3","4");

        //4.无限流
        //迭代
        Stream<Integer> integerStream = Stream.iterate(0,(x)->x=x+1);
        //流不使用则无效
        integerStream.limit(10).forEach(System.out::println);

        //生成
        Stream<Person> stream = Stream.generate(Person::new);
        stream.forEach(x->{
            log.info("{}",x);
        });

    }
}
