package cn.danao.learning.pattern.filter;

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

    /**
     * 过滤器
     *
     * @param list 需要过滤的值
     * @return 过滤结果反馈
     */
    boolean filter(List<Person> list);

}
