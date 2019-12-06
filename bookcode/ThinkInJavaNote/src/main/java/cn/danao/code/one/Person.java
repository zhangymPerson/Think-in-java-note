package cn.danao.code.one;

import java.io.Serializable;
import java.util.Objects;

/**
 * date 2019/12/6 23:10 <br/>
 * descriptionclass <br/>
 * 面向对象 实体
 * 人 -> 对象
 * <p>
 * 对象在Java开发中是很重要的概念
 * <p>
 * 面向对象思想重要概念
 * 1.封装 ->隔离复杂性 提高模块安全(私有属性，构造方法和set方法定制)
 * 2.继承 -> java中是单继承 可以实现代码服用  但是 组合 比 继承 好 有一个 和 是一个的关系
 * 3.多态 -> java 中 父类引用 指向 子类对象 重载 重写 等 都算多态 一个事物或者一个动作 多种描述
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class Person implements Serializable {

    /**
     * 编号 id
     */
    private String id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 无参构造方法
     */
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 有参构造方法
     *
     * @param id     编号id
     * @param name   姓名
     * @param remark 备注
     * @param age    年龄
     */
    public Person(String id, String name, String remark, Integer age) {
        this.id = id;
        this.name = name;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 这个方法是重写方法 Java中的类都继承自Object 是父类方法的重新实现
     *
     * @param o 判断对象
     * @return 是否一致 通过hash比较
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(remark, person.remark) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, remark, age);
    }
}
