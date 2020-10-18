package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/11 17:59 <br/>
 * description class <br/>
 * 实现Runnable接口实现多线程
 * runnable接口实现线程使用的是策略模式
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class Runner implements Runnable {
    @Override
    public void run() {
        log.info("实现runnable接口实现多继承! 自定义业务");
    }

    public static void main(String[] args) {
        //实现接口
        Thread t = new Thread(new Runner());
        //启动
        t.start();
        for (int i = 0; i < 100; i++) {
            Thread ft = new Thread(new Runner());
            ft.start();
        }
    }
}
