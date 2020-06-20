package cn.danao.learning.thread.pool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
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
    private static AtomicInteger integer = new AtomicInteger(0);

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
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100), ((r, executor) -> System.out.print("拒绝了")));
        for (int j = 0; j < 10; j++) {
            //提交100个任务
            for (int i = 0; i < 100; i++) {
                threadPoolExecutor.submit(() -> {
                    System.out.print("任务" + integer.getAndAdd(1) + " ");
                });
            }
            //获取到integer
            threadPoolExecutor.shutdown();
            if (threadPoolExecutor.isShutdown()) {
                //这个数量不准确
                System.out.println();
                log.info("任务执行了 {} 次，拒绝了 {} 次", integer.get(), 100 - integer.get());
            }
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        concurrentLinkedQueue.add("");
    }
}
