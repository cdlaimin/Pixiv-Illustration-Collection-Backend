package dev.cheerfun.pixivic.biz.notify.customer;

import com.google.common.base.Preconditions;
import dev.cheerfun.pixivic.biz.event.domain.Event;
import dev.cheerfun.pixivic.biz.notify.po.NotifyAnnounce;
import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import dev.cheerfun.pixivic.biz.notify.service.NotifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


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
            Preconditions.checkNotNull(event);
            NotifySetting notifySetting = queryNotifySetting(event.getObjectType(), event.getAction());
            Preconditions.checkNotNull(notifySetting);
            Preconditions.checkArgument(notifySetting.getWhetherNotify() || notifySetting.getWhetherPush());
            Integer sendTo = querySendTo(event);
            if (sendTo == null) {
                return;
            }
            NotifyRemind notifyRemind = generateRemind(event, sendTo, notifySetting);
            if (notifySetting.getWhetherNotify()) {
                saveNotifyRemind(notifyRemind);
            }
            if (notifySetting.getWhetherPush()) {
                push();
            }
        } catch (NullPointerException ne) {
            logger.warn("notifyEventCustomer notifyAny notifySetting is null,event:{}", event);
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.warn("notifyEventCustomer notifyAny setting no notify and push,event:{}", event);
        } catch (Exception e) {
            logger.error("notifyEventCustomer notifyAny error,event:" + event, e);
        }
    }

    protected void notifyAnnounce(Event event) {
        try {
            Preconditions.checkNotNull(event);
            NotifySetting notifySetting = queryNotifySetting(event.getObjectType(), event.getAction());
            Preconditions.checkNotNull(notifySetting);
            Preconditions.checkArgument(notifySetting.getWhetherNotify());
            NotifyAnnounce notifyAnnounce = generateAnnounce(event, notifySetting);
            saveNotifyAnnounce(notifyAnnounce);
        } catch (NullPointerException ne) {
            logger.warn("notifyEventCustomer processAnnounce notifySetting is null,event:{}", event);
        } catch (IllegalArgumentException illegalArgumentException) {
            logger.warn("notifyEventCustomer processAnnounce setting no notify and push,event:{}", event);
        } catch (Exception e) {
            logger.error("notifyEventCustomer processAnnounce error,event:" + event, e);
        }
    }


    private NotifySetting queryNotifySetting(String objectType, String action) {
        return notifyService.getNotifySetting(objectType, action);
    }

    protected Integer querySendTo(Event event) {
        throw new UnsupportedOperationException();
    }

    protected NotifyRemind generateRemind(Event event, Integer sendTo, NotifySetting notifySetting) {
        throw new UnsupportedOperationException();
    }

    protected NotifyAnnounce generateAnnounce(Event event, NotifySetting notifySetting) {
        throw new UnsupportedOperationException();
    }

    private void saveNotifyRemind(NotifyRemind remind) {
        notifyService.saveNotifyRemind(remind);
    }

    private void saveNotifyAnnounce(NotifyAnnounce notifyAnnounce) {
        notifyService.saveNotifyAnnounce(notifyAnnounce);
    }


    protected void push() {

    }


}
