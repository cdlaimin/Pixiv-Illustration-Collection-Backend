package dev.cheerfun.pixivic.biz.push.mq.config;

import dev.cheerfun.pixivic.biz.push.mq.constant.PushRabbitmqConstant;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 2020/4/17 4:18 下午
 * @description RabbitmqConfig
 */
@Configuration
public class PushRabbitmqConfig {

    @Bean(PushRabbitmqConstant.QUEUE)
    public Queue queue() {
        return new Queue(PushRabbitmqConstant.QUEUE);
    }

    @Bean(PushRabbitmqConstant.EXCHANGE)
    DirectExchange pushExchange() {
        return new DirectExchange(PushRabbitmqConstant.EXCHANGE);
    }

    @Bean
    public Binding ExchangeBindQueue(@Qualifier(PushRabbitmqConstant.QUEUE) Queue pushQueue,
                                                 @Qualifier(PushRabbitmqConstant.EXCHANGE) DirectExchange pushExchange) {
        return BindingBuilder.bind(pushQueue).to(pushExchange).with(PushRabbitmqConstant.ROUTE_KEY);
    }
}
