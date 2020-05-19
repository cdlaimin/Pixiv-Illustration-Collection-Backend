package dev.cheerfun.pixivic.biz.notify.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *  * @Description TODO
 *  * @Classname NotifyAnnounce
 *  * @Author fangzhou
 *  * @Date 2020/5/19 2:48 下午
 *  * @Version V1.0
 *  
 */
@Data
@Builder
public class NotifyAnnounce implements Serializable {
    private static final long serialVersionUID = -8480106676309444071L;
    /**
     * 公告id
     */
    private Integer notifyAnnounceId;
    /**
     * 通知类型
     */
    private String notifyType;
    /**
     * 发送方id
     */
    private Integer senderId;
    /**
     * 发送方名称
     */
    private String senderName;
    /**
     * 发送方动作
     */
    private String senderAction;
    /**
     * 关联模块对象
     */
    private String objectType;
    /**
     * 模块对象id
     */
    private Integer objectId;
    /**
     * 模块对象标题
     */
    private String objectTitle;
    /**
     * 模块对象内容
     */
    private String objectContent;
    /**
     * 创建时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createDate;
}
