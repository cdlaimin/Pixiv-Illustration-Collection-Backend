package dev.cheerfun.pixivic.biz.push.service;

import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 *  * @Description TODO
 *  * @Classname PushService
 *  * @Author fangzhou
 *  * @Date 2020/5/24 8:29 下午
 *  * @Version V1.0
 *  
 */
@Service
public class PushWrapper {

    @Autowired
    private ApplicationContext context;

    public void sendMessage(MessageDTO messageDTO) throws Exception {
        ChannelPush channelPush = getChannelPush(messageDTO.getPushPlatform());
        if(Objects.isNull(channelPush)) {
            return ;
        }
        channelPush.sendMessage(messageDTO);
    }

    private ChannelPush getChannelPush(String pushPlatform) {
        return (ChannelPush) context.getBean(pushPlatform);
    }
}
