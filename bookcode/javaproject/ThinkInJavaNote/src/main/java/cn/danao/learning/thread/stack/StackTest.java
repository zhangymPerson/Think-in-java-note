package cn.danao.learning.thread.stack;

import org.junit.Test;

/**
 * date 2020/5/13 10:32 <br/>
 * description class <br/>
 * 对 栈 的深度 进行测试
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class StackTest {

    private static int n = 0;

    public static void main(String[] args) {
        System.out.println("start");
    }


    /**
     * 使用递归测试栈溢出
     * 方法栈的深度简单测试
     */
    @Test
    public void test() {
        try {
            add(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("n = " + n);
            //java.lang.StackOverflowError
        } catch (Error error) {
            error.printStackTrace();
            System.out.println("n = " + n);
        }
    }

    /**
     * 测试函数栈
     *
     * @param i
     */
    private void add(int i) {
        //调用一次 记录一次
        n++;
        add(i++);
    }
}
