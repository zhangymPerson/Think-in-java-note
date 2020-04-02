package cn.danao.learning.closepackage;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * date 2020/3/25 18:01 <br/>
 * descriptionclass <br/>
 *
 * 闭包的测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class ClosePackage {


    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"a","b","c"});
        final int i  = 1;
        list.forEach((key)->{
            int i1 = i + 2;
            log.info("{}",i1);
        });
        Map<String,String> map = new HashMap<>();
        list.forEach((key)->{
            //map = new HashMap<>();
            map.put("123","123");
        });
        log.info("{}",map);

        int j = 0;
        Runnable run = ()->{
            System.out.println(j);
        };
        System.out.println(j);
    }
}
