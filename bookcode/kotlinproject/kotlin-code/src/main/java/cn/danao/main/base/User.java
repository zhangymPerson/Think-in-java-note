package cn.danao.main.base;

import cn.danao.main.base.bean.PersonOne;
import org.jetbrains.annotations.NotNull;

/**
 * date 2020/8/23 14:03 <br/>
 * description class <br/>
 * java对象继承 kotlin对象，要求必需是open
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class User extends PersonOne {

    /**
     * java类继承kotlin类
     *
     * @param age
     * @param name
     */
    public User(int age, @NotNull String name) {
        super(age, name);
    }

    private String userId;

    private String email;

    public User(int age, @NotNull String name, String userId, String email) {
        super(age, name);
        this.userId = userId;
        this.email = email;
    }

    // public User() {
    //Error:(37, 9) java: 无法将类 cn.danao.main.base.PersonOne中的构造器 PersonOne应用到给定类型;
    //   需要: int,java.lang.String
    //   找到: 没有参数
    //   原因: 实际参数列表和形式参数列表长度不同
    // super();
    // }

    @Override
    public String toString() {
        return "User{" +
                "age='" + getAge() + '\'' +
                "name='" + getName() + '\'' +
                "userId='" + userId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        User user = new User(10, "default");
        System.out.println(user);
    }
}
