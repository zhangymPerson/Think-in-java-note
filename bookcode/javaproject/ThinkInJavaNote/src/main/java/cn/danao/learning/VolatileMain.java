package cn.danao.learning;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * date 2020/3/21 17:17 <br/>
 * descriptionclass <br/>
 * volatile 关键字 练习
 * 保证可见性 不保证原子性 有序性
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class VolatileMain {

    public static void main(String[] args) {
        log.info("测试volatile");

        //创建公共内存中的对象
        DataObj dataObj = new DataObj();

        //线程1 修改对象
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                dataObj.add();
                log.info("线程1中对象的值 num = [{}] numa = [{}]", dataObj.num, dataObj.numa);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            //等到线程1 修改后，可以等到 程序不会卡死
//            while (dataObj.numa == 0) {
//            }
            //不加volatile 永远等不到变化 程序卡死
            //不能使用println方法 或者log 方法
            // 因为println操作是Synchronized加锁的，
            // 它会做以下的操作：1.获得同步锁；2，清空工作流出来；3.从主内存拷贝对象副本到线程工作内存中；4.开始继续执行代码；5.刷新主内存数据；6.释放同步锁。
            while (dataObj.num == 0) {
//                DataObj dataObj1 = new DataObj();
//                dataObj1.toString();
            }
            //System.out.println(dataObj);
            //log.info("线程2中对象的值 num = [{}] numa = [{}]", dataObj.num, dataObj.numa);
        }).start();
    }
}


class DataObj {

    int num = 0;

    /**
     * 一个线程变化，别的线程立马得到相应 不要使用打印语句
     */
    volatile int numa = 0;

//    public void addA(){
//        numa = 30;
//    }

    public void add() {
        num = 20;
        numa = 30;
    }

    @Override
    public String toString() {
        return "DataObj{" +
                "num=" + num +
                ", numa=" + numa +
                '}';
    }
}