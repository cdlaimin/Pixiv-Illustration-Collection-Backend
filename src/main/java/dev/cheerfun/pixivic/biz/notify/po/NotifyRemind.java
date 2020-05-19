package dev.cheerfun.pixivic.biz.notify.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 19-12-14 下午9:35
 * @description NotifyRemind
 */
@Data
@Builder
public class NotifyRemind implements Serializable {
    private static final long serialVersionUID = 8048278202507883063L;
    /**
     * 通知记录id
     */
    private Integer notifyRemindId;
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
     * 动作产生的对象id
     */
    private Integer actionObjectId;
    /**
     * 动作产生的对象的内容
     */
    private String actionObjectContent;
    /**
     * 接收者id
     */
    private Integer recipientId;
    /**
     * 创建日期
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime createDate;
    /**
     * 阅读状态
     */
    private Boolean readStatus;
    /**
     * 阅读时间
     */
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime readAt;
    /**
     * 接受公告编号
     */
    private Integer notifyAnnounceId;
}
