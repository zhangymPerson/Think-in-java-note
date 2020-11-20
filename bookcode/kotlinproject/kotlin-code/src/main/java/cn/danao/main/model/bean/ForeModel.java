package cn.danao.main.model.bean;

import cn.danao.main.model.ParentModel;
import lombok.Data;

import java.util.List;

/**
 * date 2020/11/20 14:42 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class ForeModel extends ParentModel {
    private String id;
    private String name;
    private List<String> strs;
    private List<Object> subs;

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

    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    public List<Object> getSubs() {
        return subs;
    }

    public void setSubs(List<Object> subs) {
        this.subs = subs;
    }
}
