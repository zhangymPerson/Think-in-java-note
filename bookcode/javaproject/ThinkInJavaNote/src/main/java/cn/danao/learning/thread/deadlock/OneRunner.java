package cn.danao.learning.thread.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/16 17:43 <br/>
 * description class <br/>
 * 任务 1 需要依赖任务2
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneRunner implements Runnable {

    private static final Object LOCK = new Object();

    private TwoRunner twoRunner;


    /**
     * 只提供set方法
     *
     * @param twoRunner
     */
    public void setTwoRunner(TwoRunner twoRunner) {
        this.twoRunner = twoRunner;
    }

    @Override
    public void run() {
        while (true) {
            oneMethod();
        }
    }

    public void oneMethod() {
        synchronized (LOCK) {
            log.info("任务1 - 子方法1");
            twoRunner.twoMethod2();
        }
    }

    public void oneMethod2() {
        synchronized (LOCK) {
            log.info("任务1 - 子方法2");
        }
    }
}
