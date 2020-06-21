package cn.danao.learning.obj;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * date 2020/6/19 15:40 <br/>
 * description class <br/>
 * jol java对象分析
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ObjectAnalyze {
    public static void main(String[] args) {
        System.out.println("start");
        Object obj = new Object();
        //查看对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        //查看对象外部信息
        System.out.println(GraphLayout.parseInstance(obj).toPrintable());
        //获取对象总大小
        System.out.println("size : " + GraphLayout.parseInstance(obj).totalSize());

    }
}
