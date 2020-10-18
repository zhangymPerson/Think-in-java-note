package cn.danao.learning.pattern.proxy;

import cn.danao.learning.pattern.proxy.impl.ProxyInterfaceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/5/15 9:59 <br/>
 * description class <br/>
 * 代理模式 测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ProxyTest {
    public static void main(String[] args) {

    }

    /**
     * 简单的自定义的代理模式
     */
    @Test
    public void testOne() {
        //定义 声明 执行人
        ProxyInterface proxyInterface = new ProxyInterfaceImpl();
        //将执行人委托给代理人  代理人 会 自己找到执行人执行
        ProxyServerProvide provide = new ProxyServerProvide(proxyInterface);
        Map<String, Object> map = new HashMap<>();
        //代理人提供服务
        Map<String, Object> result = provide.task(map);
        log.info("执行结果：{}", result);
    }
}
