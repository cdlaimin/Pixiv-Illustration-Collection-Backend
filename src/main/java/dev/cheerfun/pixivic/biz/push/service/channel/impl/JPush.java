package dev.cheerfun.pixivic.biz.push.service.channel.impl;

import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.service.channel.ChannelPush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 *  * @Description TODO
 *  * @Classname JPush
 *  * @Author fangzhou
 *  * @Date 2020/6/4 9:26 下午
 *  * @Version V1.0
 *  
 */
@Service("jPush")
public class JPush implements ChannelPush {


    private String MASTER_SECRET;

    private String APP_KEY;

    private JPushClient jPushClient ;

    {
        jPushClient = new JPushClient("e792096bdfcc7f2ded4c843b", "760050dd2b29ef177c17e79d", null, ClientConfig.getInstance());
    }

    public static void main(String[] args) throws Exception {
        new JPush().sendMessage(null);
    }


    @Override
    public void sendMessage(MessageDTO message) throws Exception {
        Map<String,String> map = new HashMap<>();
        map.put("aaa","132");
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.registrationId("120c83f760a55f23fb8"))
                .setMessage(Message.newBuilder()
                        .setMsgContent("Message Content")
                        .addExtra("from","Jpush")
                        .build())
                .setNotification(Notification.android("Notification Alert", "Notification Title", null))
                .build();
        PushResult pushResult = jPushClient.sendPush(pushPayload);
        System.out.println(pushResult);
    }
}
