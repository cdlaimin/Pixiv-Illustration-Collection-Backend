package dev.cheerfun.pixivic.biz.push.mq.publisher;

import dev.cheerfun.pixivic.biz.push.dto.MessageDTO;
import dev.cheerfun.pixivic.biz.push.mq.constant.PushRabbitmqConstant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  * @Description TODO
 *  * @Classname PushPublisher
 *  * @Author fangzhou
 *  * @Date 2020/5/24 9:28 下午
 *  * @Version V1.0
 *  
 */
@Service
public class PushPublisher {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(MessageDTO messageDTO) {
        this.rabbitTemplate.convertAndSend(PushRabbitmqConstant.EXCHANGE, PushRabbitmqConstant.ROUTE_KEY, messageDTO);
    }
}
