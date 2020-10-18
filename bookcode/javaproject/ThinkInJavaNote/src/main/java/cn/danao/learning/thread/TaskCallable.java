package cn.danao.learning.thread;

import java.util.concurrent.*;

/**
 * date 2020/5/11 10:52 <br/>
 * description class <br/>
 * 基于 callable 接口创建线程
 * 返回值时范型
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class TaskCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String result = "实现callable接口的方法实现返回值";
        System.out.println("执行task任务");
        return result;
    }

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        TaskCallable taskCallable = new TaskCallable();
        Future<String> result = executorService.submit(taskCallable);
        try {
            // 注意调用get方法会阻塞当前线程，直到得到结果。
            // 所以实际编码中建议使用可以设置超时时间的重载get方法。
            System.out.println("result = " + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        FutureTask<String> res = new FutureTask<>(new TaskCallable());
        try {
            String resStr = res.get();
            System.out.println("resStr = " + resStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
