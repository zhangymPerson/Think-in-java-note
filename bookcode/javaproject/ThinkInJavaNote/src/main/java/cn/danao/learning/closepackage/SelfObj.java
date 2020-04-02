package cn.danao.learning.closepackage;

import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/3/25 18:15 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class SelfObj {

    static void test(SelfInterface selfInterface,String info){
        log.info("正常逻辑");
        selfInterface.getRun(info);
        log.info("后续逻辑");
    }

    public static void main(String[] args) {
        test((key)->{
            //log.info(key);
            System.out.println("测试" + key);
        },"测试");
    }

}
