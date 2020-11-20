package cn.danao.main.lambda.java.impl;

import cn.danao.main.lambda.java.FunctionInterface;
import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/11/16 17:24 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class FunctionInterfaceImpl implements FunctionInterface {

    @Override
    public int func(int a, int b) {
        log.info("调用接口实现类 a={},b={}", a, b);
        return a + b;
    }
}
