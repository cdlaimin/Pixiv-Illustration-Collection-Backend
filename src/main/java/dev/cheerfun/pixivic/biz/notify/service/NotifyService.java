package dev.cheerfun.pixivic.biz.notify.service;

import dev.cheerfun.pixivic.biz.notify.mapper.NotifyAnnounceMapper;
import dev.cheerfun.pixivic.biz.notify.mapper.NotifyRemindMapper;
import dev.cheerfun.pixivic.biz.notify.mapper.NotifySettingMapper;
import dev.cheerfun.pixivic.biz.notify.po.NotifyAnnounce;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
public class NotifyService implements InitializingBean {

    @Autowired
    private NotifySettingMapper notifySettingMapper;

    @Autowired
    private NotifyAnnounceMapper notifyAnnounceMapper;

    @Autowired
    private NotifyRemindMapper notifyRemindMapper;

    private ConcurrentHashMap<String, NotifySetting> notifySettingMap;

    @Override
    public void afterPropertiesSet() throws Exception {
        notifySettingMap = new ConcurrentHashMap<>();
        List<NotifySetting> notifySettings = notifySettingMapper.queryNotifySettings();
        notifySettings.forEach(e -> notifySettingMap.put(e.getObjectType() + ":" + e.getNotifyAction(), e));
    }

    /**
     * 获取配置
     *
     * @param objectType
     * @param notifyAction
     * @return
     */
    public NotifySetting getNotifySetting(String objectType, String notifyAction) {
        String settingKey = objectType + ":" + notifyAction;
        NotifySetting notifySetting = notifySettingMap.get(settingKey);
        if (Objects.nonNull(notifySetting)) {
            return notifySetting;
        }
        synchronized (this) {
            notifySetting = notifySettingMap.get(settingKey);
            if (Objects.nonNull(notifySetting)) {
                return notifySetting;
            }
            notifySetting = notifySettingMapper.queryNotifySetting(objectType, notifyAction);
            if (Objects.nonNull(notifySetting)) {
                notifySettingMap.put(settingKey, notifySetting);
            }
        }
        return notifySetting;
    }

    /**
     * 保存公告
     *
     * @param notifyAnnounce
     */
    public void saveNotifyAnnounce(NotifyAnnounce notifyAnnounce) {
        notifyAnnounceMapper.save(notifyAnnounce);
    }

    /**
     * 保存通知消息
     *
     * @param notifyRemind
     */
    public void saveNotifyRemind(NotifyRemind notifyRemind) {
        notifyRemindMapper.save(notifyRemind);
    }

    /**
     * todo 用户拉取公告
     */
    public List<NotifyRemind> pullNotifyAnnounceToRemind(Integer userId) {
        return null;
    }

    /**
     * todo c段分页查询
     * @param userId
     * @return
     */
    public List<NotifyRemind> getNotifyRemindsByUserId(Integer userId) {
        return null;
    }
}
