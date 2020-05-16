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
public class TwoTask {

    private static final Object LOCK = new Object();

    private OneTask oneTask;

    public void setOneTask(OneTask oneTask) {
        this.oneTask = oneTask;
    }

    // 任务1 依赖 任务2
    public void one() {
        synchronized (LOCK) {
            log.info("任务2 - 子方法1");
        }
    }

    public void two() {
        synchronized (LOCK) {
            //任务2 调用(依赖) 任务1
            oneTask.two();
        }
    }
}
