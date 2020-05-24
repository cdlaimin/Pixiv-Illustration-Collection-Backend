package dev.cheerfun.pixivic.biz.push.service;

import dev.cheerfun.pixivic.biz.push.dao.PushSettingMapper;
import dev.cheerfun.pixivic.biz.push.dto.PixvicPushRemind;
import dev.cheerfun.pixivic.biz.push.po.PushSetting;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import dev.cheerfun.pixivic.biz.web.user.po.UserInformation;
import dev.cheerfun.pixivic.biz.web.user.service.CommonService;
import dev.cheerfun.pixivic.common.constant.RedisKeyMetaDataEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  * @Description TODO
 *  * @Classname ThridPush
 *  * @Author fangzhou
 *  * @Date 2020/5/24 3:09 下午
 *  * @Version V1.0
 *  
 */
@Service
public class PixivicPush {

    private static final Logger LOGGER = LoggerFactory.getLogger(PixivicPush.class);

    private ConcurrentHashMap<String, PushSetting> settingMap = new ConcurrentHashMap<>();

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PushSettingMapper pushSettingMapper;

    @Autowired
    private ApplicationContext context;

    public void push(PixvicPushRemind remind) {
        String objectType = remind.getObjectType();
        String senderAction = remind.getSenderAction();
        Integer recipientId = remind.getRecipientId();
        UserInformation userInformation = commonService.queryUserInformation(recipientId);
        if (Objects.isNull(userInformation)) {
            return;
        }
        PushSetting pushSetting = getPushSetting(objectType, senderAction);
        if (Objects.isNull(pushSetting)) {
            return;
        }
        String recordKey = RedisKeyMetaDataEnum.PUSH_RECORD.
                getKey(String.valueOf(recipientId), objectType, senderAction);
        Long recordNum = redisTemplate.opsForValue().increment(recordKey);
        if (!whetherPush(recordNum, pushSetting.getPushLimit())) {
            return;
        }
        // todo 发送
    }

    private boolean whetherPush(final Long recordNum, List<Long> limit) {
        for (Long l : limit) {
            if (recordNum < l) {
                return false;
            }
            if (recordNum == l) {
                return true;
            }
        }
        return false;
    }

    private PushSetting getPushSetting(String objectType, String notifyAction) {
        String key = objectType + ":" + notifyAction;
        PushSetting pushSetting = settingMap.get(objectType);
        if (Objects.nonNull(pushSetting)) {
            return pushSetting;
        }
        pushSetting = pushSettingMapper.queryPushSetting(objectType, notifyAction);
        if (Objects.nonNull(pushSetting)) {
            settingMap.putIfAbsent(key, pushSetting);
        }
        return pushSetting;
    }


    private ChannelPush getChannelPush(String pushPlatform) {
        return (ChannelPush) context.getBean(pushPlatform);
    }
}
