package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/11 17:54 <br/>
 * description class <br/>
 * 继承thread类并自定义线程内容
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoThread extends Thread {


    /**
     * 自定义线程执行内容
     */
    @Override
    public void run() {
        super.run();
        //自定义业务逻辑
        log.info("自定义业务");
    }

    public static void main(String[] args) {
        Thread t1 = new TwoThread();
        t1.start();
        //启动多个线程
        for (int i = 0; i < 1000; i++) {
            Thread t = new TwoThread();
            t.start();
        }
    }
}
