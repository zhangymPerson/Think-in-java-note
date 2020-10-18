package cn.danao.learning.pattern.proxy;

import java.util.Map;

/**
 * date 2020/5/15 10:03 <br/>
 * description class <br/>
 * 需要被代理实现的接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface ProxyInterface {

    /**
     * 要被代理的工作
     *
     * @param map
     * @return
     */
    Map<String, Object> task(Map<String, Object> map);

}
