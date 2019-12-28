package cn.danao.book;

import java.util.Map;

/**
 * @author danao
 * @version 1.0
 * @classname HandlerMapper
 * @descriptionclass
 * 1.章节跳转
 * 2.其他说明
 * @createdate 2019/7/17 18:24
 * @since 1.0
 */
public interface HandlerMapper {

    /**
     * 跳转章节信息类
     * @param params
     * @return
     */
    Map<String,Object> getBookInfo(Map<String,Object> params);

}
