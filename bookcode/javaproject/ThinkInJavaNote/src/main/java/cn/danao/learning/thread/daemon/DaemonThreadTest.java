package cn.danao.learning.thread.daemon;

/**
 * date 2020/5/13 9:53 <br/>
 * description class <br/>
 * 守护进程的设置和作用练习
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class DaemonThreadTest {

    public static void main(String[] args) {
        //工作线程
        new Thread(() -> {
            //创建守护线程
            //守护线程的创建须在需要守护的当前线程下
            Thread daemon = new Thread(() -> {
                while (true) {
                    try {
                        Thread.sleep(1_000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程:" + Thread.currentThread().getName() + " 进行健康检查，或者其他健康内容");
                }
            }, "health-checkout");
            //设置未当前线程的守护线程，如果不执行此句，则会造成 work线程结束但不退出，因为 health-checkout 线程和 work 线程之间无法控制
            //将 health-checkout 线程设置为守护线程后， work线程结束则 jvm 会 关闭守护此 health-checkout 线程
            daemon.setDaemon(true);
            daemon.start();
            try {
                System.out.println("线程:" + Thread.currentThread().getName() + " work线程start");
                Thread.sleep(10_000);
                System.out.println("线程:" + Thread.currentThread().getName() + " work线程end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "work").start();
        System.out.println("线程:" + Thread.currentThread().getName() + " 主线程结束");
    }

}
