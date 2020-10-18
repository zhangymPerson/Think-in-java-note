package cn.danao.learning.thread.lock.impl;

import cn.danao.learning.thread.lock.LockInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/20 10:14 <br/>
 * description class <br/>
 * 自定义最简单的锁
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneLockImpl implements LockInterface {

    /**
     * 状态
     */
    private volatile boolean status = false;

    @Override
    public void lock() {
        synchronized (this) {
            //不能使用if 使用if 只能在第一次的时候打断
            //log.info("锁状态 {} ", status);
            while (status) {
                //有锁等待
                try {
                    log.info("锁状态 {} ，等待锁线程 {}", status, Thread.currentThread().getName());
                    //Thread.currentThread().wait();
                    //线程等待位置，如果不用while()则在此处继续执行
                    this.wait();
                    log.info("线程 {} 结束等待", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //无锁则加锁
            status = true;
        }
    }

    @Override
    public void unLock() {
        synchronized (this) {
            log.info("{} 正在解锁", Thread.currentThread().getName());
//            this.notifyAll();
            this.notify();
            status = false;
        }
    }

}
