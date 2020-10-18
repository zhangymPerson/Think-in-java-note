package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/6/21 9:58 <br/>
 * description class <br/>
 * 两种创建线程的方式比较
 * <p>
 * 内部到包含同一个引用对象  (两种创建线程方式的比较分析)
 * 如果使用继承类 ，则 TNum对象每个线程单独持有
 * 如果使用实现接口的方式，则可以多个线程共享一个TNum对象， 就会有多线程共同使用一个变量，造成数据不一致问题
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoMethodDiffCompareTwo {
    public static void main(String[] args) {
        //处理器核数
        final int cpuNum = Runtime.getRuntime().availableProcessors();
        log.info("cpu核数 {} ", cpuNum);
        TNum tNum = new TNum();
        Task task = new Task(tNum);
        for (int i = 0; i < 2 * cpuNum; i++) {
            //实现runnable接口创建
            new Thread(new Task(tNum)).start();
        }
        for (int i = 0; i < 2 * cpuNum; i++) {
            //实现runnable接口创建
            new Thread(task).start();
        }
        for (int i = 0; i < 2 * cpuNum; i++) {
            //直接子类创建
            new TaskThread().start();
        }
    }


    /**
     * 继承实现
     */
    static class TaskThread extends Thread {
        private TNum tNum = new TNum();

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work();
                tNum.add();
                log.info("继承Thread类-完成任务[{}] tNum = [{}]", i,tNum.num);
            }
        }

        private void work() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现接口
     */
    static class Task implements Runnable {
        private TNum tNum;

        public Task(TNum tNum) {
            this.tNum = tNum;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work();
                tNum.add();
                log.info("实现接口-完成任务[{}]，tNum = [{}]", i,tNum.num);
            }
        }

        private void work() {
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class TNum {
        private int num = 0;

        public void add() {
            num++;
        }
    }
}
