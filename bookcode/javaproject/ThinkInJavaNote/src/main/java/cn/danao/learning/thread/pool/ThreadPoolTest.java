package cn.danao.learning.thread.pool;

import java.util.concurrent.*;

/**
 * date 2020/5/18 18:34 <br/>
 * description class <br/>
 * 线程池的使用
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        one();
        two();
    }

    /**
     * Future 一般作为 submit() 的返回值使用，并在主线程中以阻塞的方式获取异步任务的执行结果。
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void one() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        TestTask task = new TestTask();
        System.out.println("主线程启动线程池");
        Future<Integer> future = executor.submit(task);
        System.out.println("主线程得到返回结果：" + future.get());
        executor.shutdown();
    }

    /**
     * FutureTask 集「任务与结果」于一身，所以我们可以使用 FutureTask 自身而非返回值来管理任务
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void two() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        TestTask task = new TestTask();
        System.out.println("主线程启动线程池");
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        // 作为Ruunable传入submit()中
        executor.submit(futureTask);
        // 作为Future获取结果
        System.out.println("主线程得到返回结果：" + futureTask.get());
        executor.shutdown();
    }
}
