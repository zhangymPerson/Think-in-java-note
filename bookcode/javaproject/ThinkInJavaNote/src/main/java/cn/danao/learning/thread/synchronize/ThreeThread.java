package cn.danao.learning.thread.synchronize;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/16 17:11 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ThreeThread implements Runnable {
    private static final Object LOCK = new Object();
    private volatile int i = 1;

    private static int Max = 50;

    @Override
    public void run() {
        while (true) {
            if (lockStatus()) {
                break;
            }
        }
    }

    /**
     * 锁 的粒度缩小
     *
     * @return
     */
    private synchronized boolean lockStatus() {
        if (i > Max) {
            return true;
        }
        log.info("i = {}", i);
        try {
            Thread.sleep(0_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;
        return false;
    }

    public static void main(String[] args) {
        Runnable runnable = new ThreeThread();
        Thread t1 = new Thread(runnable, "测试 - 1");
        Thread t2 = new Thread(runnable, "测试 - 2");
        Thread t3 = new Thread(runnable, "测试 - 3");
        t1.start();
        t2.start();
        t3.start();
    }
}
