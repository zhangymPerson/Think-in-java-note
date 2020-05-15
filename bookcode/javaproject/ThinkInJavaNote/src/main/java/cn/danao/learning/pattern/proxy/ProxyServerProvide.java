package cn.danao.learning.pattern.proxy;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * date 2020/5/15 10:05 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ProxyServerProvide implements ProxyInterface {

    private ProxyInterface proxyInterface;

    public ProxyServerProvide(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    /**
     * 代理服务类
     * 具体的服务由构造函数中实例化的代理提供,服务提供者类不负责具体的实现
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> task(Map<String, Object> map) {
        log.info("代理服务商接收到task");
        Map<String, Object> result = proxyInterface.task(map);
        log.info("真正的实现提供者实现后，走代理类返回给调用者");
        return result;
    }
}
