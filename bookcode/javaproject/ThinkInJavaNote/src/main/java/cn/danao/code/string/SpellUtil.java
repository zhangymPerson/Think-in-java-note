package cn.danao.code.string;

import org.slf4j.helpers.MessageFormatter;

/**
 * date 2020/6/12 14:39 <br/>
 * description class <br/>
 * 拼写工具类 字符串拼接 拼写规则 和 log.info("{}",var) 差不多
 * 
 * @author danao
 * @version 1.0
 * @since 1.0
 */
public class SpellUtil {
    /**
     * 使用log4j的工具类封装
     * <p>
     * 使用 spellStr("hello = {}","hello") 返回 hello = hello;
     * 
     * hutool 中的 也可以实现字符串拼接
     * 
     * cn.hutool.core.util.StrUtil.format("{},{}",a,b);
     * 
     * @param message
     * @param argumentArray
     * @return
     */
    public static String spellStr(String message, Object... argumentArray) {
        String formattedMessage = "";
        if (argumentArray != null) {
            formattedMessage = MessageFormatter.arrayFormat(message, argumentArray).getMessage();
        } else {
            formattedMessage = message;
        }
        return formattedMessage;
    }
}