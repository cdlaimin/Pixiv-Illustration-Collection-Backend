package dev.cheerfun.pixivic.biz.notify.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  * @Description TODO
 *  * @Classname push_setting
 *  * @Author fangzhou
 *  * @Date 2020/5/19 11:43 上午
 *  * @Version V1.0
 *  
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotifySetting implements Serializable {
    private static final long serialVersionUID = -4490388411262726884L;

    /**
     * 通知配置id
     */
    private Long notifySettingId;

    /**
     * 所属模块
     */
    private String objectType;

    /**
     * 动作
     */
    private String notifyAction;

    /**
     * 通知类型
     */
    private String notifyType;

    /**
     * 是否通知
     */
    private Boolean whetherNotify;

    /**
     * 是否推送
     */
    private Boolean whetherPush;
}
