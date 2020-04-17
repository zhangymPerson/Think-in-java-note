package cn.danao.learning.filter;

import cn.danao.learning.lambda.bean.Person;

import java.util.List;

/**
 * date 2020/4/17 10:51 <br/>
 * descriptionclass <br/>
 * <p>
 * 前置过滤器规则
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface BeforeFilter {

    boolean filter(List<Person> list);

}
