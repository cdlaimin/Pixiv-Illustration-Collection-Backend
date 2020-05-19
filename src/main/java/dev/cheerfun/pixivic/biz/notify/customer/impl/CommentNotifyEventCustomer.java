package dev.cheerfun.pixivic.biz.notify.customer.impl;

import dev.cheerfun.pixivic.biz.event.constant.ObjectType;
import dev.cheerfun.pixivic.biz.event.domain.Event;
import dev.cheerfun.pixivic.biz.notify.customer.NotifyEventCustomer;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 2020/3/18 11:23 上午
 * @description CommentNotifyEventCustomer
 */
@Component(ObjectType.COMMENT)
@RabbitListener(queues = ObjectType.COMMENT)
public class CommentNotifyEventCustomer extends NotifyEventCustomer {

    @Override
    @RabbitHandler()
    public void consume(Event event) {
        super.notifyAny(event);
    }

    @Override
    protected Integer querySendTo(Event event) {
        return 123;
    }

    @Override
    protected NotifyRemind generateRemind(Event event, Integer sendTo, NotifySetting notifySetting) {
        return NotifyRemind.builder()
                .senderId(event.getUserId())
                .senderName(event.getUserName())
                .notifyType(notifySetting.getNotifyType())
                .senderAction(event.getAction())
                .objectType(event.getObjectType())
                .objectId(event.getObjectId())
                // todo objectTitle content actionObjectId
                .actionObjectId(event.getActionObjectId())
                .recipientId(sendTo).build();
    }

}
