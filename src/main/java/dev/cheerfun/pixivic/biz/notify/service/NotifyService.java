package dev.cheerfun.pixivic.biz.notify.service;

import dev.cheerfun.pixivic.biz.notify.mapper.NotifySettingMapper;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  * @Description TODO
 *  * @Classname NotifySettingService
 *  * @Author fangzhou
 *  * @Date 2020/5/19 11:57 上午
 *  * @Version V1.0
 *  
 */
@Service
public class NotifyService {

    @Autowired
    private NotifySettingMapper notifySettingMapper;

    private ConcurrentHashMap<String, NotifySetting> notifySettingMap;

    public NotifySetting getNotifySetting(String objectType, String notifyAction) {
        return null;
    }

    public void saveNotifyRemind(NotifyRemind notifyRemind) {

    }
}
