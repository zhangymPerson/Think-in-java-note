package cn.danao.main.base;

/**
 * date 2020/8/23 14:17 <br/>
 * description class <br/>
 * java父类对象被 kotlin对象继承
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class Parent {

    public String id;

    public String name;

    /**
     * 私有属性
     */
    private int age;

    public Parent() {
    }

    public Parent(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
