package cn.danao.main.base.bean;

/**
 * date 2020/11/19 10:19 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class PersonJava {

    /**
     * 私有
     */
    private String argOne;

    /**
     * 公有
     */
    public String argTwo;

    /**
     * 默认
     */
    String argThree;

    @Override
    public String toString() {
        return "PersonJava{" +
                "argOne='" + argOne + '\'' +
                ", argTwo='" + argTwo + '\'' +
                ", argThree='" + argThree + '\'' +
                '}';
    }

    public PersonJava() {
    }

    public PersonJava(String argOne, String argTwo, String argThree) {
        this.argOne = argOne;
        this.argTwo = argTwo;
        this.argThree = argThree;
    }

    public String getArgOne() {
        return argOne;
    }

    // public void setArgOne(String argOne) {
    //     this.argOne = argOne;
    // }

    public String getArgTwo() {
        return argTwo;
    }

    public void setArgTwo(String argTwo) {
        this.argTwo = argTwo;
    }

    public String getArgThree() {
        return argThree;
    }

    public void setArgThree(String argThree) {
        this.argThree = argThree;
    }


}
