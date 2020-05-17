package cn.danao.learning.thread.provide;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/17 9:47 <br/>
 * description class <br/>
 * 生产者 消费者1 模型
 * <p>
 * 生产者只负责生产 。消费者消费时。抢到锁以后，发现消费者多次消费同一个消息 。
 *
 * 生产者线程每次生产多条新的消息，
 *
 * 但消费者线程则随机选择一条消息 并且多次消费这一消息
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneProvide {

    //消息
    private int i = 0;

    private final static Object LOCK = new Object();

    public void client() {
        //消费 读取
        synchronized (LOCK) {
            log.info("消费 {}", i);
        }
    }

    public void provide() {
        synchronized (LOCK) {
            //生产 i
            log.info("生产到了 {}", ++i);
        }
    }

    public static void main(String[] args) {
        OneProvide provide = new OneProvide();
        new Thread("生产者线程") {
            @Override
            public void run() {
                //不停生产
                while (true) {
                    provide.provide();
                }
            }
        }.start();

        new Thread("消费者线程") {
            @Override
            public void run() {
                while (true) {
                    provide.client();
                }
            }
        }.start();
    }
}
