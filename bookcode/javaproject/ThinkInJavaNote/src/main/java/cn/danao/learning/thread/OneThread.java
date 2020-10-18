package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/11 17:50 <br/>
 * description class <br/>
 * 继承thread类
 * 无任何内容的测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneThread extends Thread {

    /**
     * 继承线程，不做任何实现。则无任何输出
     *
     * @param args
     */
    public static void main(String[] args) {
        Thread t0 = new Thread();
        t0.start();
        log.info("线程t0执行完");
        Thread t1 = new OneThread();
        t1.start();
        log.info("线程t1执行完");
    }
}
