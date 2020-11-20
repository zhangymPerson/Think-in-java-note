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
public class ThreeModel extends ParentModel {
    private String id;
    private String name;
    private List<String> strs;
    private List<ForeModel> foreModels;

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

    public List<ForeModel> getForeModels() {
        return foreModels;
    }

    public void setForeModels(List<ForeModel> foreModels) {
        this.foreModels = foreModels;
    }

    public static ThreeModel init() {
        ThreeModel threeModel = new ThreeModel();
        threeModel.setId("1");
        threeModel.setName("name");
        List<String> list = Arrays.asList("a");
        threeModel.setStrs(list);
        ForeModel foreModel = new ForeModel();
        foreModel.setId("2");
        foreModel.setName("twoModel");
        foreModel.setStrs(list);
        List<ForeModel> twoModels = Arrays.asList(foreModel);
        threeModel.setForeModels(twoModels);
        return threeModel;
    }
}
