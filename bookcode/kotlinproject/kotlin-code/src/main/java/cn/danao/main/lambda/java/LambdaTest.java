package cn.danao.main.lambda.java;

import cn.danao.main.lambda.java.impl.FunctionInterfaceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * date 2020/11/16 17:26 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
public class LambdaTest {

    /**
     * 后面的是lambda的函数参数
     *
     * @param a
     * @param b
     * @param functionInterface
     * @return
     */
    public int lambdaJavaFunc(int a, int b, FunctionInterface functionInterface) {
        return functionInterface.func(a, b);
    }

    @Test
    public void test() {
        //接口调用
        FunctionInterface functionInterface = new FunctionInterfaceImpl();
        int a = 5, b = 5;
        int i = lambdaJavaFunc(a, b, functionInterface);
        int j = lambdaJavaFunc(a, b, (x, y) -> {
            log.info("调用lambda表达式");
            return x * y;
        });
        log.info("a={},b={},i={},j={}", a, b, i, j);
    }
}
