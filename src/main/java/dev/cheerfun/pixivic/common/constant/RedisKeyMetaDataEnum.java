package dev.cheerfun.pixivic.common.constant;

import java.util.concurrent.TimeUnit;

/**
 *  * @Description TODO
 *  * @Classname RedisKeyMetaDataEnum
 *  * @Author fangzhou
 *  * @Date 2020/5/21 8:39 下午
 *  * @Version V1.0
 *  
 */
public enum RedisKeyMetaDataEnum {

    NOTIFY_EVENT_REPLACE("no","en",":",60L * 60L,TimeUnit.SECONDS);

    /**
     * 模块
     */
    private String model;
    /**
     * 前缀
     */
    private String prefix;
    /**
     * 分隔符
     */
    private String split;

    /**
     * 超时时间
     */
    private Long expired;

    /**
     * 时间单位
     */
    private TimeUnit timeUnit;

    RedisKeyMetaDataEnum(String model, String prefix, String split, Long expired, TimeUnit timeUnit) {
        this.model = model;
        this.prefix = prefix;
        this.split = split;
        this.expired = expired;
        this.timeUnit = timeUnit;
    }

    public String getModel() {
        return model;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSplit() {
        return split;
    }

    public Long getExpired() {
        return expired;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public String getKey() {
        return model + split + prefix;
    }

    public String getKey(String bizKey) {
        return model + split + prefix + split + bizKey;
    }

    @Override
    public String toString() {
        return "RedisKeyMetaDataEnum{" +
                "model='" + model + '\'' +
                ", prefix='" + prefix + '\'' +
                ", split='" + split + '\'' +
                ", expired=" + expired +
                ", timeUnit=" + timeUnit +
                '}';
    }
}
