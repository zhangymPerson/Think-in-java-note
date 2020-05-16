package cn.danao.learning.thread.deadlock;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/16 18:35 <br/>
 * description class <br/>
 * 任务 1
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneTask {

    private static final Object LOCK = new Object();

    private TwoTask twoTask;

    public void setTwoTask(TwoTask twoTask) {
        this.twoTask = twoTask;
    }

    public void one() {
        synchronized (LOCK) {
            //任务1 调用(依赖) 任务2
            twoTask.one();
        }
    }

    public void two() {
        synchronized (LOCK) {
            log.info("任务1 - 子方法2");
        }
    }
}
