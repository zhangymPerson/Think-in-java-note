package cn.danao.learning.thread.deadlock;

/**
 * date 2020/5/16 17:51 <br/>
 * description class <br/>
 * 死锁的产生测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
//        testOne();
        testTwo();
    }

    public static void testOne() {
        //多个任务互相依赖 使用 jconsole 查看线程死锁情况
        OneRunner oneRunner = new OneRunner();
        TwoRunner twoRunner = new TwoRunner(oneRunner);
        oneRunner.setTwoRunner(twoRunner);

        Thread t0 = new Thread(oneRunner, "测试1 - 任务1 线程");
        Thread t1 = new Thread(twoRunner, "测试1 - 任务2 线程");

        //一运行就死锁
        t0.start();
        t1.start();
    }

    public static void testTwo() {
        OneTask oneTask = new OneTask();
        TwoTask twoTask = new TwoTask();
        //任务互相依赖
        oneTask.setTwoTask(twoTask);
        twoTask.setOneTask(oneTask);

        //启动两个线程执行两个任务
        new Thread(() -> {
            while (true) {
                oneTask.one();
            }
        }, "测试2 - 任务1 线程").start();

        new Thread(() -> {
            while (true) {
                twoTask.two();
            }
        }, "测试2 - 任务2 线程").start();

        //这种死锁不易发现，需要在 Jconsole 中 查看检测
    }
}
