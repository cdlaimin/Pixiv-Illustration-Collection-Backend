package dev.cheerfun.pixivic.common.exception;

/**
 *  * @Description TODO
 *  * @Classname NotifyProcessException
 *  * @Author fangzhou
 *  * @Date 2020/5/21 8:56 下午
 *  * @Version V1.0
 *  
 */
public class NotifyProcessException extends RuntimeException {
    public NotifyProcessException() {
    }

    public NotifyProcessException(String message) {
        super(message);
    }

    public NotifyProcessException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotifyProcessException(Throwable cause) {
        super(cause);
    }

    public NotifyProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
