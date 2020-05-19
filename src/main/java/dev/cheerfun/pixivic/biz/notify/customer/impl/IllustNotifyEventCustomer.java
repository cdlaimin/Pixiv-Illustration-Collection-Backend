package dev.cheerfun.pixivic.biz.notify.customer.impl;

import dev.cheerfun.pixivic.biz.event.constant.ObjectType;
import dev.cheerfun.pixivic.biz.event.domain.Event;
import dev.cheerfun.pixivic.biz.notify.customer.NotifyEventCustomer;
import dev.cheerfun.pixivic.biz.notify.po.NotifyAnnounce;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 2020/3/18 2:32 下午
 * @description IllustNotifyEventCustomer
 */
@Component(ObjectType.ILLUST)
@RabbitListener(queues = ObjectType.ILLUST)
public class IllustNotifyEventCustomer extends NotifyEventCustomer {

    @Override
    @RabbitHandler()
    public void consume(Event event) {
        super.notifyAnnounce(event);
    }

    @Override
    protected NotifyAnnounce generateAnnounce(Event event, NotifySetting notifySetting) {
        return null;
    }
}
