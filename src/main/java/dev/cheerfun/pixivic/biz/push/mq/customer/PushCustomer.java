package dev.cheerfun.pixivic.biz.push.mq.customer;

import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.mq.constant.PushRabbitmqConstant;
import dev.cheerfun.pixivic.biz.push.service.PushWrapper;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *  * @Description TODO
 *  * @Classname PushCustomer
 *  * @Author fangzhou
 *  * @Date 2020/5/24 9:34 下午
 *  * @Version V1.0
 *  
 */
@Component()
@RabbitListener(queues = PushRabbitmqConstant.QUEUE)
public class PushCustomer {

    @Autowired
    private PushWrapper pushWrapper;

    @RabbitHandler()
    public void consume(MessageDTO messageDTO) throws Exception {
        pushWrapper.sendMessage(messageDTO);
    }
}
