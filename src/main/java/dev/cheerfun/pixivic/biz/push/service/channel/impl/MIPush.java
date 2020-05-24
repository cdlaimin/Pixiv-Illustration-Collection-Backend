package dev.cheerfun.pixivic.biz.push.service.channel.impl;

import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(MIPush.class);


    public void sendMessage() throws Exception {
        Constants.useSandbox();
        Sender sender = new Sender("");
        String messagePayload = "This is a message";
        String title = "notification title";
        String description = "notification description";
        Message message = new Message.Builder()
                .title(title)
                .description(description)
                .payload(messagePayload)
                .restrictedPackageName("")
                .notifyType(1)     // 使用默认提示音提示
                .build();
        Result result = sender.send(message, "123", 3);

    }
}
