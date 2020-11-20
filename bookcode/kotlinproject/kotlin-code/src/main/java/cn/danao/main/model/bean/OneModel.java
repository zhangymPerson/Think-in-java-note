package cn.danao.main.model.bean;

import cn.danao.main.model.ParentModel;

import java.util.Arrays;
import java.util.List;

/**
 * date 2020/11/20 14:42 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class OneModel extends ParentModel {
    private String id;
    private String name;
    private List<String> strs;
    private List<TwoModel> twoModels;

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

    public List<TwoModel> getTwoModels() {
        return twoModels;
    }

    public void setTwoModels(List<TwoModel> twoModels) {
        this.twoModels = twoModels;
    }

    public static OneModel init() {
        OneModel oneModel = new OneModel();
        oneModel.setId("1");
        oneModel.setName("name");
        List<String> list = Arrays.asList("a");
        oneModel.setStrs(list);
        List<TwoModel> twoModels = Arrays.asList(TwoModel.init());
        oneModel.setTwoModels(twoModels);
        return oneModel;
    }
}
