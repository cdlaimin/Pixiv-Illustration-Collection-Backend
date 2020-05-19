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
 * @date 2020/3/18 2:33 下午
 * @description CollectionNotifyEventCustomer
 */
@Component(ObjectType.COLLECTION)
@RabbitListener(queues = ObjectType.COLLECTION)
public class CollectionNotifyEventCustomer extends NotifyEventCustomer {

    @Override
    @RabbitHandler()
    public void consume(Event event) {
        super.notifyAny(event);
    }

    @Override
    protected Integer querySendTo(Event event) {
        return null;
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
