package cn.danao.learning.thread.provide;

import cn.danao.learning.thread.bean.DataEntity;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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

    private static Integer ONE_MAX = 100;

    private static Integer TWO_MAX = 200;

    private static Integer Three_MAX = 300;


    /**
     * 此处如果不加 static 则 在main线程中创建该线程时，所有线程都是从 index - max 执行 ， 即 每个线程都创建100个对象
     * 如果多个线程需要访问同一个变量，多个线程总共创建100个对象，则需要加 static  添加static之后，多个线程访问同一变量
     * <p>
     * 静态变量：线程非安全 线程间读取此变量值混乱
     * <p>
     * 加入 volatile
     */
    private volatile static Integer index = 1;

    private static List<DataEntity> dataEntityList = new ArrayList<>();

    private static final Object object = new Object();

    /**
     * 为了解决以下问题，即创建的 data id 和 msg 数据错误问题，
     * 加 synchronized 关键字 也不能避免 下面注释中的问题
     * <p>
     * 加入 volatile 关键字不能解决下面的问题 线程数多的时候 还是会乱
     */
    @Override
    public void run() {
        //生成对象
        //如果不用锁，则会出现不合法的消息，即 有 id 重复， 有id 消失
        //synchronized 锁定整个对象，只有一个线程运行 原因未分析到
        synchronized (object) {
            //因为此处是死循环，即启动第一个线程后，如果使用 synchronized 关键字后，
            // 由于第一个线程启动一直不释放锁，导致其他线程一直等锁，
            // 所以一直不执行，直到第一个启动的线程执行完之后释放锁
            //通过拆分，使每个范围的值到不同的线程上，执行完一部分释放一个锁
            while (TWO_MAX < index && index <= Three_MAX) {
                //多线程生产的 msg 不准确
                /**
                 * 前几个线程启动时。有问题，到6之后正常了
                 * 创建对象有问题， index值不一致 有很多null对象被创建的问题
                 */
                //读取同一变量，不一致问题 ???
                DataEntity dataEntity = new DataEntity(String.valueOf(index), "msg = " + index);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataEntityList.add(dataEntity);
                index++;
                log.info("线程 [{}] , 生产的消息 [{}]", Thread.currentThread().getName(), dataEntity.toString());
            }
            while (ONE_MAX < index && index <= TWO_MAX) {
                //多线程生产的 msg 不准确
                /**
                 * 前几个线程启动时。有问题，到6之后正常了
                 * 创建对象有问题， index值不一致 有很多null对象被创建的问题
                 */
                //读取同一变量，不一致问题 ???
                DataEntity dataEntity = new DataEntity(String.valueOf(index), "msg = " + index);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataEntityList.add(dataEntity);
                index++;
                log.info("线程 [{}] , 生产的消息 [{}]", Thread.currentThread().getName(), dataEntity.toString());
            }
            while (0 < index && index <= ONE_MAX) {
                //多线程生产的 msg 不准确
                /**
                 * 前几个线程启动时。有问题，到6之后正常了
                 * 创建对象有问题， index值不一致 有很多null对象被创建的问题
                 */
                //读取同一变量，不一致问题 ???
                DataEntity dataEntity = new DataEntity(String.valueOf(index), "msg = " + index);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                dataEntityList.add(dataEntity);
                index++;
                log.info("线程 [{}] , 生产的消息 [{}]", Thread.currentThread().getName(), dataEntity.toString());
            }
            return;
        }
    }

    public static void main(String[] args) {
        /**
         * 测试多个线程访问变量，静态变量的问题
         */
        //线程2 和 3 没有运行
        //没有运行的原因是 run方法是 死循环， 且上锁， 所以一个线程启动后，不执行完，就不释放锁，其他线程没有执行机会
        new Thread(new ProvideThread(), "测试线程2").start();
        new Thread(new ProvideThread(), "测试线程1").start();
        new Thread(new ProvideThread(), "测试线程3").start();

//        log.info("[ {} ]", dataEntityList);
        //创建的对象信息前后不一致的
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataEntityList.forEach(dataEntity -> {
            if (dataEntity != null && !dataEntity.getMsg().endsWith(dataEntity.getId())) {
                log.info("异常的消息有 {}", dataEntity);
            }
        });
        final int i = 0;
        //有空消息的数量和非空的数量
        Stream stream = dataEntityList.stream();
        Long nullNum = stream.filter(k -> k == null).count();
        stream = dataEntityList.stream();
        Long noNull = stream.filter(k -> k != null).count();
        log.info("非空对象数量是[{}],null对象的数量是[{}]", noNull, nullNum);
    }
}
