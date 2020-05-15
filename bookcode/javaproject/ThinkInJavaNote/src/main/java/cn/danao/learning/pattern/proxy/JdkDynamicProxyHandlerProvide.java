package cn.danao.learning.pattern.proxy;

import cn.danao.learning.pattern.proxy.impl.ProxyInterfaceImpl;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/5/15 10:21 <br/>
 * description class <br/>
 * jdk提供的动态代理实现
 * 需要先实现 InvocationHandler 接口
 * 实现该接口 则 代理对象由实现类动态实现
 * <p>
 * 代理对象的获取需要使用
 * java.lang.reflect.Proxy 对象的 newProxyInstance 方法实现
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class JdkDynamicProxyHandlerProvide implements InvocationHandler {

    private ProxyInterface proxyInterface;

    public JdkDynamicProxyHandlerProvide(ProxyInterface proxyInterface) {
        this.proxyInterface = proxyInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = null;      // 设置方法的返回值
        ret = method.invoke(proxyInterface, args);       //invoke调用需要代理的方法
        after();
        return ret;
    }

    private void before() {//方法执行前
        System.out.println("方法执行前 !");
    }

    private void after() {//方法执行后
        System.out.println("方法执行后");
    }


    /**
     * 获取被代理接口实例对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(proxyInterface.getClass().getClassLoader(), proxyInterface.getClass().getInterfaces(), this);
    }

    /**
     * 测试动态代理调用
     *
     * @param args
     */
    public static void main(String[] args) {
        //执行者
        ProxyInterface proxyRun = new ProxyInterfaceImpl();
        //执行时 获取到动态代理对象
        ProxyInterface proxy = (ProxyInterface) Proxy.newProxyInstance(ProxyInterface.class.getClassLoader(), new Class[]{ProxyInterface.class}, new JdkDynamicProxyHandlerProvide(proxyRun));
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> result = proxy.task(map);
        log.info("执行结果 1 == {}", result);


        // jdk动态代理测试
        //执行者
        ProxyInterface proxyRunTwo = new ProxyInterfaceImpl();
        //在jdk动态内部类里实现getProxy()方法提供动态代理对象
        ProxyInterface proxyInterface = new JdkDynamicProxyHandlerProvide(proxyRunTwo).getProxy();
        Map<String, Object> results = proxyInterface.task(new HashMap<>());
        log.info("执行结果 2 == {}", results);
    }

}
