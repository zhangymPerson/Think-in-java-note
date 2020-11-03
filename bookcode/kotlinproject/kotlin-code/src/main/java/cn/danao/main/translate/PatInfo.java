package cn.danao.main.translate;

import lombok.Data;

/**
 * date 2020/9/19 10:10 <br/>
 * description class <br/>
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
public class PatInfo {
    /**
     * 患者标识
     */
    private String patient_id;
    /**
     * 姓名
     */
    private String person_name;
    /**
     * 姓名拼音
     */
    private String name_phonetic;
    /**
     * 性别名称
     */
    private String sex_name;
    /**
     * 出生日期
     */
    private String date_of_birth;
    /**
     * 国籍名称
     */
    private String nation_name;
    /**
     * 民族名称
     */
    private String nationality_name;
    /**
     * 证件类型
     */
    private String id_card_type;
    /**
     * 证件号码
     */
    private String id_card_no;
    /**
     * 出生详细地址
     */
    private String birth_address;
    /**
     * 血型名称
     */
    private String blood_type_name;
    /**
     * RH血型名称
     */
    private String rh_blood_name;
    /**
     * 患者身份名称
     */
    private String identity_name;
    /**
     * 籍贯名称
     */
    private String native_province_name;
    /**
     * 户籍所在地省份名称
     */
    private String family_addr_province_name;
    /**
     * 户籍所在地地市名称
     */
    private String family_addr_city_name;
    /**
     * 户籍所在地区县名称
     */
    private String family_addr_county_name;
    /**
     * 出生所在地省份名称
     */
    private String birth_addr_province_name;
    /**
     * 出生所在地地市名称
     */
    private String birth_addr_city_name;
    /**
     * 出生所在地区县名称
     */
    private String birth_addr_county_name;
    /**
     * 新生儿年龄
     */
    private String baby_age;
    /**
     * 新生儿出生体重
     */
    private String baby_birth_weight;
    /**
     * 新生儿入院体重
     */
    private String baby_admin_weight;

}
