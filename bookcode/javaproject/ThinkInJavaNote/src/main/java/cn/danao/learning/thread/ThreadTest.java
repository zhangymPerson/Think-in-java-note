package cn.danao.learning.thread;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * date 2020/4/21 10:38 <br/>
 * descriptionclass <br/>
 * 线程普通测试
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
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                log.info("线程1");
            }
        }).start();
        one();
    }

    @Test
    public void test() {
        //普通线程
        //log.info("start");
        one();
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

}
