package cn.danao.learning.thread.synchronize;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * date 2020/5/14 14:31 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class OneThread extends Thread {

    public static final Object object = new Object();
    public static int i = 0;

    public OneThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        synchronized (object) {
            int k = ++i;
            log.info("执行线程。i = {}", k);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            Thread t = new OneThread("自定义线程" + i);
            t.start();
        }

    }
}
