package dev.cheerfun.pixivic.biz.notify.customer.impl;

import dev.cheerfun.pixivic.common.constant.RedisKeyMetaDataEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  * @Description TODO
 *  * @Classname Test
 *  * @Author fangzhou
 *  * @Date 2020/5/19 9:26 下午
 *  * @Version V1.0
 *  
 */
@RestController
public class Test {
    @Autowired
    IllustNotifyEventCustomer commentNotifyEventCustomer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/123/123")
    public void test() {
        String key = RedisKeyMetaDataEnum.NOTIFY_EVENT_REPLACE.getKey("eventId");
        if (!redisTemplate.opsForValue().setIfAbsent(key, "true",
                RedisKeyMetaDataEnum.NOTIFY_EVENT_REPLACE.getExpired(),
                RedisKeyMetaDataEnum.NOTIFY_EVENT_REPLACE.getTimeUnit())) {
            System.out.println(111);
        }
    }
}
