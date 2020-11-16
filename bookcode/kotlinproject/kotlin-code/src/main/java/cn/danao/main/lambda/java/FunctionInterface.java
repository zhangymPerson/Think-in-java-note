package cn.danao.main.lambda.java;

/**
 * date 2020/11/16 17:21 <br/>
 * description class <br/>
 * 自定义 lambda 表达式接口
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public interface FunctionInterface {
    /**
     * 传入两个整数，返回一个整数
     *
     * @param a
     * @param b
     * @return
     */
    int func(int a, int b);
}
