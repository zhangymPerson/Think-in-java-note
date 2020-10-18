package cn.danao.learning.thread.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * date 2020/5/12 10:12 <br/>
 * description class <br/>
 * 消息实体
 *
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Slf4j
@Data
@AllArgsConstructor
@ToString
public class DataEntity {
    /**
     * id
     */
    private String id;

    /**
     * 消息内容
     */
    private String msg;
}
