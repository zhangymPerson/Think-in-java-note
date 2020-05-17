package cn.danao.learning.thread.provide;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * date 2020/5/17 9:47 <br/>
 * description class <br/>
 * 生产者 消费者2 模型
 * <p>
 * 消息添加状态，生产和消费到修改对应的状态 可以控制消息的传递
 * 单个消息时，可以使用此模式
 * <p>
 * 重点在消息状态的添加和锁机制 有了消息状态和锁 就可以控制生产消费模型
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoProvide {

    //消息
    private int i = 0;

    private static int MAX = 100;

    private final static Object LOCK = new Object();

    //消息状态
    private volatile boolean isProvide = false;

    public void client() {
        //消费 读取
        synchronized (LOCK) {
            if (isProvide) {
                log.info("消费 {}", i);
                isProvide = false;
            }
        }
    }

    public void provide() {
        synchronized (LOCK) {
            //生产 i
            if (!isProvide) {
                //方便测试。限制数量
                if (i < MAX) {
                    log.info("生产到了 {}", ++i);
                    isProvide = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        TwoProvide provide = new TwoProvide();

        Stream.of("p1", "p2", "p3").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        //不停生产
                        while (true) {
                            provide.provide();
                        }
                    }
                }.start()
        );

        Stream.of("c1", "c2", "c3").forEach(n ->
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            provide.client();
                        }
                    }
                }.start()
        );
    }
}
