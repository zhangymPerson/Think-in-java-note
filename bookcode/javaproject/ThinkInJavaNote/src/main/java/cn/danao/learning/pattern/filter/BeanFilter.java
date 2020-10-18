package cn.danao.learning.pattern.filter;

import cn.danao.learning.lambda.bean.Person;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * date 2020/4/17 11:08 <br/>
 * descriptionclass <br/>
 * 在bean对象中进行过滤
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
@Slf4j
public class BeanFilter {

    List<Person> list;

    public BeanFilter(List<Person> list) {
        this.list = list;
    }

    public void beforeFilter(BeforeFilter filter) {
        log.info("在bean内调用前置过滤");
        filter.filter(list);
    }

    public void afterFilter(AfterFilter filter) {
        log.info("在bean内调用后置过滤");
        filter.filter(list);
    }
}
