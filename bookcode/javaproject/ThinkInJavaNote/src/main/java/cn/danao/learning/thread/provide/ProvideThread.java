package cn.danao.learning.thread.provide;

import cn.danao.learning.thread.bean.DataEntity;
import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/12 10:08 <br/>
 * description class <br/>
 * 生产者线程
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ProvideThread implements Runnable {

    private static Integer MAX = 100;


    /**
     * 此处如果不加 static 则 在main线程中创建该线程时，所有线程都是从 index - max 执行 ， 即 每个线程都创建100个对象
     * 如果多个线程需要访问同一个变量，多个线程总共创建100个对象，则需要加 static  添加static之后，多个线程访问同一变量
     * <p>
     * 静态变量：线程非安全 线程间读取此变量值混乱
     */
    private static Integer index = 1;

    /**
     * 为了解决以下问题，即创建的 data id 和 msg 数据错误问题，
     * 需要加 synchronized 关键字 避免 下面注释中的问题
     */
    @Override
    synchronized public void run() {
        //生成对象
        while (index <= MAX) {
            //多线程生产的 msg 不准确
            /**
             * 2020-05-12 10:28:29  [ Thread-3:0 ] - [ INFO ]  线程 [Thread-3] , 生产的消息 [DataEntity(id=2, msg=msg = 6)]
             * 2020-05-12 10:28:29  [ Thread-2:0 ] - [ INFO ]  线程 [Thread-2] , 生产的消息 [DataEntity(id=4, msg=msg = 6)]
             * 2020-05-12 10:28:29  [ Thread-4:0 ] - [ INFO ]  线程 [Thread-4] , 生产的消息 [DataEntity(id=3, msg=msg = 6)]
             * 2020-05-12 10:28:29  [ Thread-1:0 ] - [ INFO ]  线程 [Thread-1] , 生产的消息 [DataEntity(id=5, msg=msg = 6)]
             * 2020-05-12 10:28:29  [ Thread-0:0 ] - [ INFO ]  线程 [Thread-0] , 生产的消息 [DataEntity(id=1, msg=msg = 6)]
             * 前几个线程启动时。有问题，到6之后正常了
             */
            DataEntity dataEntity = new DataEntity(String.valueOf(index++), "msg = " + index);
            log.info("线程 [{}] , 生产的消息 [{}]", Thread.currentThread().getName(), dataEntity.toString());
        }
    }

    public static void main(String[] args) {
        /**
         * 测试多个线程访问变量，静态变量的问题
         */
        for (int i = 0; i < 5; i++) {
            new Thread(new ProvideThread()).start();
        }
    }
}
