package cn.danao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname Application
 * @descriptionclass
 * 1.项目主类
 * 2.其他说明
 * @createdate 2019/7/17 18:19
 * @since 1.0
 */
public class Application {

    public static void main(String[] args) {
        //项目入口
        System.out.println("项目启动");
        run(args);
    }

    public static void run(String[] args){
        //todo 业务
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        for (String k : list) {
            System.out.println(k);
        }

    }

}
