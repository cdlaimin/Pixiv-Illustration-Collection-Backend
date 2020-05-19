package dev.cheerfun.pixivic.biz.notify.customer.impl;

import dev.cheerfun.pixivic.biz.event.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  * @Description TODO
 *  * @Classname Test
 *  * @Author fangzhou
 *  * @Date 2020/5/19 9:26 下午
 *  * @Version V1.0
 *  
 */
@Controller
public class Test {
    @Autowired
    CommentNotifyEventCustomer commentNotifyEventCustomer;

    @RequestMapping("fanggzhou/test")
    public void test() {
        Event event = Event.builder()
                .userId(123)
                .userName("test")
                .objectType("test")
                .action("test")
                .objectId(123)
                .build();
        commentNotifyEventCustomer.consume(event);
    }
}
