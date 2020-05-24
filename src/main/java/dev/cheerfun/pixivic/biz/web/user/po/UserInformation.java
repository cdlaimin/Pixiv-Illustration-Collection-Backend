package dev.cheerfun.pixivic.biz.web.user.po;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *  * @Description TODO
 *  * @Classname UserInformation
 *  * @Author fangzhou
 *  * @Date 2020/5/24 1:57 下午
 *  * @Version V1.0
 *  
 */
@Data
@Builder
public class UserInformation {
    private Integer userInformationId;
    private Integer userId;
    private String phoneModel;
    private String pushPlatform;
    private String pushUniqueCode;
    private LocalDateTime lastUpdatedTime;
}
