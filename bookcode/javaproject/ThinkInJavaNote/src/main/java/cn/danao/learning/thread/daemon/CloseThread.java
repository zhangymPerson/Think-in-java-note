package cn.danao.learning.thread.daemon;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * date 2020/5/14 9:47 <br/>
 * description class <br/>
 * 线程关闭 的 方式
 * 把工作线程设置为守护线程，超时关闭该线程，则守护线程自己停止运行
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class CloseThread {

    //启动时间
    long start = System.currentTimeMillis();

    Thread t = null;

    /**
     * 执行一个线程
     * <p>
     * 利用守护线程会随着宿主线程的消失而消失，可以实现线程超时的一个简单的实现
     *
     * @param run
     */
    public void executeThread(Runnable run) {
        t = new Thread(() -> {
            Thread runT = new Thread("work") {
                @Override
                public void run() {
                    run.run();
                }
            };
            //设置守护线程是关键
            runT.setDaemon(true);
            runT.start();
        }, "task-daemon");
        t.start();
    }

    /**
     * 超时关闭线程
     * 每隔 1s 检查一次
     *
     * @param time
     */
    public void shutdownThread(long time) {
        while (true) {
            try {
                //隔 1s 检查下时间
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long now = System.currentTimeMillis();
            if (now - start > time) {
                log.info("{},{},{}", start, now, now - start);
                log.info("执行超时，打断");
                t.interrupt();
                return;
            }
        }
    }


    public static void main(String[] args) {
        CloseThread closeThread = new CloseThread();
        closeThread.executeThread(() -> {
            log.info("run start");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("run end");
        });
        closeThread.shutdownThread(4000);
        //测试
        test();
    }

    /**
     * 在一个线程对象上调用interrupt()方法，真正有影响的是wait，join，sleep方法，当然这三个方法包括它们的重载方法。
     * 请注意：[上面这三个方法都会抛出InterruptedException]，
     * 一个线程在调用interrupt()后，自己不会抛出InterruptedException异常，所以你看到interrupt()并没有抛出这个异常，
     * 所以 测试方法中 线程 测试线程 正在执行while(条件) log.info("----doing work");
     * 你调用a.interrupt();后线程会继续正常地执行下去。如果抛出异常不处理
     */
    public static void test() {
        Thread t = new Thread(() -> {
            //判断线程是否打断，如果打断，则不执行 但是如果 线程中有调用 sleep.wait join 方法后，将异常捕获后，线程状态被修改
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    //线程睡眠也会修改打断状态，如果抛出异常不处理，则下面的打断状态 获取不到，
                    // 该成打断状态 但是 执行完之后，会改成非打断状态，所以会一直打印
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
                log.info("---doing work----");
            }
            try {
                //抛异常方法一：
//            Thread.sleep(1000); //会拋一个异常
                //抛异常方法二：手动抛异常
                for (int i = 0; i < 100; i++) {
                    log.info("已经停止了！准备退出");
                    throw new InterruptedException();
                }
            } catch (InterruptedException e) {
                log.error("打断并捕获抛出的异常，此处可以添加线程被打断后，资源释放等工作，异常信息:", e);
            }
            log.info("线程执行完毕");
        }, "测试线程");
        t.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打断线程 将线程信号 修改为打断状态
        t.interrupt();

    }
}
