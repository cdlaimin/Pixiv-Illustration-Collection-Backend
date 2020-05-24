package dev.cheerfun.pixivic.biz.push.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *  * @Description TODO
 *  * @Classname MessageDTO
 *  * @Author fangzhou
 *  * @Date 2020/5/24 8:20 下午
 *  * @Version V1.0
 *  
 */
@Data
public class MessageDTO implements Serializable {
    private static final long serialVersionUID = -687845248418773883L;

    /**
     * 使用哪个平台推送
     */
    private String pushPlatform;
    /**
     * 该平台唯一用户code
     */
    private String pushUniqueCode;
}
