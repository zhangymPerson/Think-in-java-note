package cn.danao.learning.pattern.filter;

import cn.danao.learning.lambda.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * date 2020/4/17 10:53 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class FilterTest {

    /**
     * 测试过滤器
     */
    @Test
    public void test() {
        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        list.add(new Person());
        //业务中调用过滤
        beforeFun((k) -> {
            log.info("执行前置的过滤");
            return true;
        }, list);

        afterFun((k) -> {
            log.info("执行后置的过滤");
            return true;
        }, list);

        //在bean中调用过滤
        BeanFilter beanFilter = new BeanFilter(list);

        beanFilter.beforeFilter((k) -> {
            log.info("执行前置的过滤");
            return true;
        });

        beanFilter.afterFilter((k) -> {
            log.info("执行后置的过滤");
            return true;
        });

    }

    /**
     * 模拟业务
     *
     * @param filter     过滤器
     * @param personList 过滤内容
     */
    private void beforeFun(BeforeFilter filter, List<Person> personList) {
        log.info("开始处理");
        //调用过滤器 -> 可以根据接口扩展
        filter.filter(personList);
        //执行其他的相关业务
        log.info("业务逻辑");
        log.info("end");
    }

    private void afterFun(AfterFilter filter, List<Person> personList) {
        log.info("开始处理");
        //调用过滤器 -> 可以根据接口扩展
        filter.filter(personList);
        log.info("业务逻辑");
        //执行其他的相关业务
        log.info("end");
    }
}
