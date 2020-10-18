package cn.danao.learning;

/**
 * date 2020/3/22 10:28 <br/>
 * descriptionclass <br/>
 * 单例模式 双端检锁机制
 * 避免指令重排的问题
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class Singleton {
    private static volatile Singleton singleton = null;

    private Singleton() {
        System.out.println("创建对象");
    }

    //懒汉式 双端检锁
    //指令重排的问题 需要加volatile
    static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(() -> {
                Singleton singleton = getSingleton();
            }).start();
        }
    }
}
