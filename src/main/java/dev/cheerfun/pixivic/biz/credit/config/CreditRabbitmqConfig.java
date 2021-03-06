package dev.cheerfun.pixivic.biz.credit.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author OysterQAQ
 * @version 1.0
 * @date 2020/4/17 9:31 下午
 * @description CreditRabbitmqConfig
 */
@Configuration
public class CreditRabbitmqConfig {
    @Bean("creditFanOutExchange")
    FanoutExchange creditFanOutExchange() {
        return new FanoutExchange("creditFanOutExchange");
    }

    @Bean
    public Binding creditExchangeBindFanoutExchange(FanoutExchange fanoutExchange, FanoutExchange creditFanOutExchange) {
        return BindingBuilder.bind(creditFanOutExchange).to(fanoutExchange);
    }

    @Bean("creditQueue")
    public Queue creditQueue() {
        return new Queue("creditQueue");
    }

    @Bean
    public Binding creditExchangeBindCreditQueue(Queue creditQueue, FanoutExchange creditFanOutExchange) {
        return BindingBuilder.bind(creditQueue).to(creditFanOutExchange);
    }
}
