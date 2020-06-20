package cn.danao.learning.thread.consume;

import lombok.Data;
import lombok.ToString;

/**
 * date 2020/6/20 8:52 <br/>
 * description class <br/>
 * 消息
 * @author danao
 * @version 1.0
 * @since 1.0
 */
@Data
@ToString
public class MessageInfo {
    /**
     * 消息id
     */
    private String id;
    /**
     * 消息内容
     */
    private String msg;
}
