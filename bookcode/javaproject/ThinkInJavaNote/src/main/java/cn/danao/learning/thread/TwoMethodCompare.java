package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/6/21 9:58 <br/>
 * description class <br/>
 * 两种创建线程的方式比较
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TwoMethodCompare {
    public static void main(String[] args) {
        //处理器核数
        final int cpuNum = Runtime.getRuntime().availableProcessors();
        log.info("cpu核数 {} ", cpuNum);
        for (int i = 0; i < 2 * cpuNum; i++) {
            //实现runnable接口创建
            new Thread(new Task()).start();
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
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work();
                log.info("继承Thread类-完成任务[{}]", i);
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

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                work();
                log.info("实现接口-完成任务[{}]", i);
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
}
