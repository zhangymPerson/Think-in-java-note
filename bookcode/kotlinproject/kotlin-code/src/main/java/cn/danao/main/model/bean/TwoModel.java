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
public class TwoModel extends ParentModel {
    private String id;
    private String name;
    private List<String> strs;
    private List<ThreeModel> threeModels;

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

    public List<ThreeModel> getThreeModels() {
        return threeModels;
    }

    public void setThreeModels(List<ThreeModel> threeModels) {
        this.threeModels = threeModels;
    }

    public static TwoModel init() {
        TwoModel twoModel = new TwoModel();
        twoModel.setId("1");
        twoModel.setName("name");
        List<String> list = Arrays.asList("a");
        twoModel.setStrs(list);
        List<ThreeModel> twoModels = Arrays.asList(ThreeModel.init());
        twoModel.setThreeModels(twoModels);
        return twoModel;
    }
}
