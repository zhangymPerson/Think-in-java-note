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

    private static Integer MAX = 100;


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

    /**
     * 为了解决以下问题，即创建的 data id 和 msg 数据错误问题，
     * 加 synchronized 关键字 也不能避免 下面注释中的问题
     * <p>
     * 加入 volatile 关键字不能解决下面的问题 线程数多的时候 还是会乱
     */
    @Override
    public void run() {
        //生成对象
        while (index <= MAX) {
            //多线程生产的 msg 不准确
            /**
             * 前几个线程启动时。有问题，到6之后正常了
             * 创建对象有问题， index值不一致 有很多null对象被创建的问题
             */
            synchronized (this) {
                //读取同一变量，不一致问题 ???
                DataEntity dataEntity = new DataEntity(String.valueOf(index), "msg = " + index);
                dataEntityList.add(dataEntity);
                index++;
                log.info("线程 [{}] , 生产的消息 [{}]", Thread.currentThread().getName(), dataEntity.toString());
            }
        }
    }

    public static void main(String[] args) {
        /**
         * 测试多个线程访问变量，静态变量的问题
         */
        for (int i = 0; i < 500; i++) {
            new Thread(new ProvideThread()).start();
        }
//        log.info("[ {} ]", dataEntityList);
        //创建的对象信息前后不一致的
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
