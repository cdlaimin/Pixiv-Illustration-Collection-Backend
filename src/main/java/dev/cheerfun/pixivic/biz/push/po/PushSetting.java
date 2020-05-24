package dev.cheerfun.pixivic.biz.push.po;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  * @Description TODO
 *  * @Classname PushSetting
 *  * @Author fangzhou
 *  * @Date 2020/5/24 3:30 下午
 *  * @Version V1.0
 *  
 */
@Data
@Builder
public class PushSetting implements Serializable {
    private Integer pushSettingId;
    private String objectType;
    private String notifyAction;
    private String pushTemplateIcon;
    private String pushTemplateTitle;
    private String pushTemplateDescOne;
    private List<String> pushTemplateParamOne;
    private String pushTemplateDescPolymerizate;
    private List<String> pushTemplateParamPolymerizate;
    private List<Long> pushLimit;
    private String launcherActivity;
}
