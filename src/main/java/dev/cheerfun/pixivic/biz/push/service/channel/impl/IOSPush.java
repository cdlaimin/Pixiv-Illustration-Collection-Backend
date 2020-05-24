package dev.cheerfun.pixivic.biz.push.service.channel.impl;

import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import org.springframework.stereotype.Service;

import java.nio.channels.Channel;

/**
 *  * @Description TODO
 *  * @Classname IOSPush
 *  * @Author fangzhou
 *  * @Date 2020/5/24 8:05 下午
 *  * @Version V1.0
 *  
 */
@Service("IOSPush")
public class IOSPush implements ChannelPush {
    @Override
    public void sendMessage(MessageDTO message) throws Exception {

    }
}
