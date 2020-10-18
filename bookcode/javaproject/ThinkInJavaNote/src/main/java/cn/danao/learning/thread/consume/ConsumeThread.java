package cn.danao.learning.thread.consume;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * date 2020/5/12 10:10 <br/>
 * description class <br/>
 * 消费者线程测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ConsumeThread implements Runnable {
    /**
     * 自增id
     */
    private static AtomicInteger integer = new AtomicInteger(0);
    /**
     * 消息队列
     */
    private Queue<MessageInfo> messageInfoList = new LinkedList<>();

    @Override
    public void run() {
        //生成者线程
        Stream.of("provide1", "provide2").forEach(k -> {
            new Thread(() -> {
                //生产者线程
                while (true) {
                    synchronized (messageInfoList) {
                        if (messageInfoList.size() < 4) {
                            MessageInfo info = new MessageInfo();
                            info.setId(integer.toString());
                            info.setMsg("消息内容");
                            //add()和remove()方法在失败的时候会抛出异常(不推荐)
                            messageInfoList.offer(info);
                            log.info("生产了消息{}", info);
                            integer.getAndIncrement();
//                            messageInfoList.notifyAll();
                        } else {
                            messageInfoList.notifyAll();
                            try {
                                messageInfoList.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //多个生产者生产完之后，全部wait,此句不会执行，需要在wait前notify
                            //messageInfoList.notifyAll();
                        }
                    }
                }
            }, k).start();
        });

        Stream.of("consume1", "consume2", "consume3", "consume4", "consume5").forEach(k -> {
            new Thread(() -> {
                //消费者线程
                while (true) {
                    synchronized (messageInfoList) {
                        if (messageInfoList.size() > 0) {
                            //返回第一个元素，并在队列中删除
                            MessageInfo info = messageInfoList.poll();
                            log.info("消费了消息:{}", info);
//                            messageInfoList.notifyAll();
                        } else {
                            try {
                                messageInfoList.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            //提醒生产
//                            messageInfoList.notifyAll();
                        }
                    }
                }
            }, k).start();
        });
    }

    public static void main(String[] args) {
        ConsumeThread consumeThread = new ConsumeThread();
        new Thread(consumeThread).run();
    }
}
