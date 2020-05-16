package cn.danao.learning.thread.synchronize;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/16 15:55 <br/>
 * description class <br/>
 * this锁 对象锁
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoThread implements Runnable {

    private static final Object LOCK = new Object();
    private volatile int i = 1;

    private static int Max = 50;

    @Override
    public void run() {
        //此处加的锁只有一个线程能执行，其他线程只能等待全部任务完成
        synchronized (TwoThread.class) {
            while (true) {
                if (i > Max) {
                    break;
                }
                log.info("i = {}", i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new TwoThread();
        Thread t1 = new Thread(runnable, "测试 - 1");
        Thread t2 = new Thread(runnable, "测试 - 2");
        Thread t3 = new Thread(runnable, "测试 - 3");
        t1.start();
        t2.start();
        t3.start();
    }

}
