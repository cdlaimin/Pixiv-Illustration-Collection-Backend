package dev.cheerfun.pixivic.biz.push.service.channel.impl;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;
import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *  * @Description TODO
 *  * @Classname MIPush
 *  * @Author fangzhou
 *  * @Date 2020/5/24 2:44 下午
 *  * @Version V1.0
 *  
 */
@Service("MIPush")
public class MIPush implements ChannelPush {

    @Value("${MIPush.security}")
    private String security;

    private Sender sender;

    {
        // 使用线上环境
        sender = new Sender(security);
        Constants.useOfficial();
    }

    public void sendMessage(MessageDTO message) throws Exception {

        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message miMessage = new Message.Builder()
                .title(title)
                .description(description)
                .payload(messagePayload)
                .restrictedPackageName("")
                .notifyType(1)     // 使用默认提示音提示
                .build();
        Result result = sender.send(miMessage, "123", 3);
    }

    // todo
    public Message buildMessage(MessageDTO messageDTO) {
        return null;
    }
}
