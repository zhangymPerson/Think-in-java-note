package cn.danao.learning.lambda.bean;

import lombok.Data;
import lombok.ToString;

/**
 * date 2020/4/6 8:39 <br/>
 * descriptionclass <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class Person {
    private String id;
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
