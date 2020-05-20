package cn.danao.learning.thread.lock;

/**
 * date 2020/5/20 10:13 <br/>
 * description class <br/>
 * lock锁接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface LockInterface {

    /**
     * 加锁
     */
    void lock();

    /**
     * 释放锁
     */
    void unLock();

}
