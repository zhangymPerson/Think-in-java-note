package cn.danao.learning.thread.provide;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * date 2020/5/17 9:47 <br/>
 * description class <br/>
 * 生产者 消费者3 模型
 * <p>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ThreeProvide {

    //消息
    private int i = 0;

    private static int MAX = 100;

    private final static Object LOCK = new Object();

    private boolean isProvide = false;

    public void client() {
        //消费 读取
        synchronized (LOCK) {
            if (isProvide) {
                log.info("消费 {}", i);
                try {
                    //消费完等待
                    //wait()方法会导致当前线程无限期地等待直到另一个线程调用该对象的notify()或notifyAll()方法。
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isProvide = false;
            } else {
                //无消息，通知生产
                LOCK.notify();
            }
        }
    }


    public void provide() {
        synchronized (LOCK) {
            //生产 i
            //方便测试。限制数量
            if (!isProvide) {
//                if (i < MAX) {
                log.info("生产到了 {}", ++i);
                try {
                    //生产完等待
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                isProvide = true;
//                }
            } else {
                //通知消费
                LOCK.notify();
            }
        }
    }

    /**
     * 测试线程时 不要使用 Test测试框架，不然有各种问题
     *
     * @param args
     */
    public static void main(String[] args) {
        oneThread();
//        moreThread();
    }

    //单线程的生产消费没有问题
    public static void oneThread() {
        ThreeProvide provide = new ThreeProvide();
        //单线程 生产
        new Thread() {
            @Override
            public void run() {
                //不停生产
                while (true) {
                    provide.provide();
                }
            }
        }.start();
        //单线程 消费
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    provide.client();
                }
            }
        }.start();
    }

    //多线程生产和消费
    //notify 激活线程的顺序 于 jdk的版本和实现有关
    //执行时会唤醒以锁对象为标识符的线程池中等待线程中其中一个
    //如果在代码中使用的 wait 和 notify 则发现生产和消费 混乱
    public static void moreThread() {
        ThreeProvide provide = new ThreeProvide();
        //stream替换for循环
        Stream.of("p1", "p2", "", "", "").forEach(n ->
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

        Stream.of("c1", "c2", "", "", "").forEach(n ->
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
