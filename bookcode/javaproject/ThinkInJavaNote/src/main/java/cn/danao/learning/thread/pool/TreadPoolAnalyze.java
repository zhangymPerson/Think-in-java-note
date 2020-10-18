package cn.danao.learning.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * date 2020/6/19 17:38 <br/>
 * description class <br/>
 * 线程池创建测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class TreadPoolAnalyze {
    /**
     * 任务id
     */
    private static AtomicInteger integer = new AtomicInteger(0);

    /**
     * 拒绝的数量
     */
    private static AtomicInteger fail = new AtomicInteger(0);

    public static void main(String[] args) {
        //线程池
        /**
         *参数信息：
         * int corePoolSize     核心线程大小
         * int maximumPoolSize  线程池最大容量大小
         * long keepAliveTime   线程空闲时，线程存活的时间
         * TimeUnit unit        时间单位
         * BlockingQueue<Runnable> workQueue  任务队列。一个阻塞队列
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 20, 10000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(200), ((r, executor) -> {
            //失败的任务统计
            fail.addAndGet(1);
            log.info("r ={} \n executor = {}", r, executor);
        }));

        //并发提交n个任务
        int maxTask = 1000;
        for (int i = 0; i < maxTask; i++) {
            threadPoolExecutor.submit(() -> {
                log.info("任务" + integer.getAndAdd(1) + " ");
                //模拟每个任务执行耗时
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            //try {
            //    Thread.sleep(1_000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}
        }
        //关闭线程池的方法
        threadPoolExecutor.shutdown();
        if (threadPoolExecutor.isShutdown()) {
            //这个数量不准确
            System.out.println();
            log.info("任务执行了 {} 次，拒绝了 {} 次", threadPoolExecutor.getCompletedTaskCount(), fail);
        }
        System.out.println("主线程开始检测线程池活动线程个数...");
        /**总共检测20秒，每隔2秒检测一次
         * 当活动线程为0(即任务执行完毕)时，关闭线程池*/
        for (int i = 0; i < 10; i++) {
            log.info("主线程判断池中正活动线程数：" + threadPoolExecutor.getActiveCount());
            log.info("主线程判断池中已完成线程数：" + threadPoolExecutor.getCompletedTaskCount());
            log.info("任务执行了 {} 次，拒绝了 {} 次", threadPoolExecutor.getCompletedTaskCount(), fail);
            //活跃的线程数为0时停止线程池
            if (threadPoolExecutor.getActiveCount() <= 0) {
                threadPoolExecutor.shutdown();
                break;
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
