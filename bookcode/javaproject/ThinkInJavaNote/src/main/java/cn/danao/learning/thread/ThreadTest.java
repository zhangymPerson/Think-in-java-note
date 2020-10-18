package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * date 2020/4/21 10:38 <br/>
 * descriptionclass <br/>
 * 线程普通测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ThreadTest {


    /**
     * 普通线程的创建测试
     *
     * @param args
     */
    public static void main(String[] args) {
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                log.info("线程1");
//            }
//        }).start();
//        one();
        for (int i = 0; i < 10; i++) {
            System.out.println("==========================================" + i + "====================================");
            two();
        }
    }

    /**
     * 单元测试中多线程有问题;主线程结束就结束子线程
     */
    @Test
    public void test() {
        //普通线程
        //log.info("start");
//        one();
        for (int i = 0; i < 1; i++) {
            System.out.println("==========================================" + i + "====================================");
            two();
        }
        //普通线程
//        log.info("end");
    }

    public static void one() {
        log.info("start");
        System.out.println("start");
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
//                System.out.println("线程1");
                log.info("线程1");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                System.out.println("线程2");
                log.info("线程2");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                log.info("线程3");
            }
        }).start();
        new Thread(() -> {
            while (true) {
                log.info("线程4");
            }
        }).start();
//        new Thread(()->{
//            while (true){
//                log.info("线程5");
//            }
//        }).start();
        log.info("end");
    }

    /**
     * 多线程读取同一个变量，java.util.ConcurrentModificationException
     */
    public static void two() {
        List<String> list = new ArrayList<>(Arrays.asList("one", "two", "three"));
        //同一个n 多个线程读
        int n = 10;
        Thread thread = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                System.out.println("1 - " + n + " - " + i);
                System.out.println("thread1 list的长度" + list.size());
            }
            System.out.println("thread1结束");
        });
        thread.start();
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                System.out.println("2 - " + n + " - " + i);
                synchronized (list) {
                    Iterator<String> iterator = list.iterator();
                    System.out.println("list = {}" + list);
                    while (iterator.hasNext()) {
                        if (iterator.next().equals("测试")) {
                            iterator.remove();
                            System.out.println("删除成功");
                        }
                    }
                }
            }
            System.out.println("thread2结束");
        });
        thread2.start();
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                //添加成功
                System.out.println("3 - " + n + " - " + i);
                synchronized (list) {
                    list.add("测试");
                }
            }
            System.out.println("thread3结束");
        });
        thread3.start();
        synchronized (list) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
