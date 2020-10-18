package cn.danao.learning.thread.lock;

import cn.danao.learning.thread.lock.impl.OneLockImpl;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.Stream;

/**
 * date 2020/5/20 10:12 <br/>
 * description class <br/>
 * lock 自定义锁测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class LockTest {

    public static void main(String[] args) {
        one();
    }

    public static void one() {
        //定义锁
        LockInterface lock = new OneLockImpl();
        //多线程测试
        Stream.of("t1", "t2", "t3").forEach(name -> {
            new Thread(() -> {
                //加锁
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "已经启动");
                try {
                    log.info("{} 线程工作，在锁中进行", Thread.currentThread().getName());
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.unLock();
            }, name).start();
            //第一种自定义锁有bug,就是加锁和解锁的不是同一线程
            //mian线程可以解掉 t1线程上加的锁
            lock.unLock();
        });
    }
}
