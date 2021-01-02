package cn.danao.learning.thread.pool;

import java.util.concurrent.Callable;

/**
 * date 2020/12/14 10:15 <br/>
 * description class <br/>
 * 测试多线程任务的
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class TestTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("子线程开始计算...");
        for (int i = 0; i < 3; ++i) {
            Thread.sleep(1_000);
            System.out.println("子线程计算中，用时 " + (i + 1) + " 秒");
        }
        System.out.println("子线程计算完成，返回：1");
        return 1;
    }
}
