package cn.danao.learning.pattern.proxy.impl;

import cn.danao.learning.pattern.proxy.ProxyInterface;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * date 2020/5/15 10:10 <br/>
 * description class <br/>
 * 代理业务真正实现的位置
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ProxyInterfaceImpl implements ProxyInterface {
    @Override
    public Map<String, Object> task(Map<String, Object> map) {
        log.info("真正实现task任务的 被代理的人，开始执行task");
        map.put("task执行类", this.getClass().getName());
        map.put("info", "任务结果");
        return map;
    }
}
