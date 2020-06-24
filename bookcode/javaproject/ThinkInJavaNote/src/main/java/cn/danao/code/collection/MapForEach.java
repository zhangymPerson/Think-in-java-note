package cn.danao.code.collection;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * date 2020/6/24 10:28 <br/>
 * description class <br/>
 * map的foreach遍历
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class MapForEach {

    static Map<Integer, String> map = new HashMap() {
        {
            for (int var = 0; var < 5; ++var) {
                this.put(var, "val:" + var);
            }
        }
    };

    @Test
    public void test() {
        forTest();
        forEachTest();
        lambdaTest();
        moreThreadLambdaTest();
    }

    public void forTest() {
        log.info("for===========================================");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        }
        System.out.println();
    }

    public void forEachTest() {
        log.info("foreach===========================================");
        for (Integer key : map.keySet()) {
            System.out.print(key);
            System.out.print(map.get(key));
        }
        System.out.println();
    }

    public void lambdaTest() {
        log.info("lambda===========================================");
        map.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(value);
        });
        System.out.println();
    }

    public void moreThreadLambdaTest() {
        log.info("多线程lambda===========================================");
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });
        System.out.println();
    }
}
