package dev.cheerfun.pixivic.biz.push.service.channel;

import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;

/**
 *  * @Description TODO
 *  * @Classname ChannelPush
 *  * @Author fangzhou
 *  * @Date 2020/5/24 3:10 下午
 *  * @Version V1.0
 *  
 */
public interface ChannelPush {
    void sendMessage(MessageDTO message) throws Exception;
}
