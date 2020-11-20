package cn.danao.main.model.kotlin;

import cn.danao.main.model.bean.OneModel;

/**
 * date 2020/11/20 14:56 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class SpellTest {

    public static void main(String[] args) {
        test(null);
        test(new OneModel());
        test(OneModel.init());
    }

    public static void test(OneModel oneModel) {
        StringBuffer stringBuffer = new StringBuffer();
        if (oneModel == null) {
            return;
        }
        if (oneModel.getStrs() != null) {
            oneModel.getStrs().forEach(k -> {
                stringBuffer.append("oneModel中strs").append(k);
            });
        }
        if (oneModel.getTwoModels() != null) {
            oneModel.getTwoModels().forEach(twoModel -> {
                if (twoModel != null) {
                    if (twoModel.getThreeModels() != null) {
                        twoModel.getThreeModels().forEach(threeModel -> {
                            if (threeModel != null) {
                                if (threeModel.getStrs() != null) {
                                    threeModel.getStrs().forEach(s -> {
                                        stringBuffer.append("threeModel中的strs").append(s);
                                    });
                                }
                            }
                        });
                    }
                }
            });
        }
        System.out.println("str = " + stringBuffer);
    }
}
