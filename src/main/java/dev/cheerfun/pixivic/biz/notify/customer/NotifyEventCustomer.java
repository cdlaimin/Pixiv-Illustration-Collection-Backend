package dev.cheerfun.pixivic.biz.notify.customer;

import com.google.common.base.Preconditions;
import dev.cheerfun.pixivic.biz.event.domain.Event;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import dev.cheerfun.pixivic.biz.notify.service.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


public abstract class NotifyEventCustomer {

    private static final Logger logger = LoggerFactory.getLogger(NotifyEventCustomer.class);

    @Autowired
    private NotifyService notifyService;

    protected abstract void consume(Event event);

    /**
     * 不做大范围通知，大范围通知用别的方案
     *
     * @param event
     */
    protected void notifyAny(Event event) {
        try {
            NotifySetting notifySetting = notifyService.getNotifySetting(event.getObjectType(), event.getAction());
            Preconditions.checkNotNull(notifySetting);
            Preconditions.checkArgument(notifySetting.getWhetherNotify() || notifySetting.getWhetherPush());
            Integer sendTo = querySendTo(event);
            if (sendTo == null) {
                return;
            }
            NotifyRemind notifyRemind = generateRemind(event, sendTo, notifySetting);
            if(notifySetting.getWhetherNotify()) {
                saveNotifyRemind(notifyRemind);
            }
            if(notifySetting.getWhetherPush()) {
                push();
            }
        } catch (NullPointerException ne) {
            logger.warn("notifyEventCustomer notifySetting is null,event:{}", event);
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.warn("notifyEventCustomer setting no notify and push,event:{}", event);
        } catch (Exception e) {
            logger.error("notifyEventCustomer process error,event:" + event, e);
        }
    }

    protected Integer querySendTo(Event event) {
        throw new UnsupportedOperationException();
    }

    protected NotifyRemind generateRemind(Event event, Integer sendTo, NotifySetting notifySetting) {
        return NotifyRemind.builder()
                .senderId(event.getUserId())
                .senderName(event.getUserName())
                .notifyType(notifySetting.getNotifyType())
                .senderAction(event.getAction())
                .objectType(event.getObjectType())
                .objectId(event.getObjectId())
                .objectTitle(event.getObjectTitle())
                .recipientId(sendTo)
                .createDate(LocalDateTime.now())
                .readStatus(false)
                .readAt(null).build();
    }

    protected void saveNotifyRemind(NotifyRemind remind) {
        notifyService.saveNotifyRemind(remind);
    }

    protected void push() {

    }


}
