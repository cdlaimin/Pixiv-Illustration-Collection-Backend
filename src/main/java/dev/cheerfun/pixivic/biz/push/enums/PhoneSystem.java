package dev.cheerfun.pixivic.biz.push.enums;

/**
 *  * @Description TODO
 *  * @Classname PhoneSystem
 *  * @Author fangzhou
 *  * @Date 2020/5/24 8:58 下午
 *  * @Version V1.0
 *  
 */
public enum PhoneSystem {
    ANDROID("android"),
    IOS("IOS");

    String code;

    PhoneSystem(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "PhoneSystem{" +
                "code='" + code + '\'' +
                '}';
    }
}
