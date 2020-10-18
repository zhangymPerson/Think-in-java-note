package cn.danao.learning.thread.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/16 17:43 <br/>
 * description class <br/>
 * 任务 2 也可能依赖任务1
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoRunner implements Runnable {

    private OneRunner oneRunner;
    private static final Object LOCK = new Object();

    public TwoRunner(OneRunner oneRunner) {
        this.oneRunner = oneRunner;
    }

    @Override
    public void run() {
        while (true) {
            twoMethod();
        }
    }

    public void twoMethod() {
        synchronized (LOCK) {
            log.info("任务2 - 子方法1");
            oneRunner.oneMethod2();
        }
    }

    public void twoMethod2() {
        synchronized (LOCK) {
            log.info("任务2 - 子方法2");
        }
    }
}
