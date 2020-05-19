package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import org.apache.ibatis.annotations.Mapper;

/**
 *  * @Description TODO
 *  * @Classname NotifyRemindMapper
 *  * @Author fangzhou
 *  * @Date 2020/5/19 3:14 下午
 *  * @Version V1.0
 *  
 */
@Mapper
public interface NotifyRemindMapper {
    void save(NotifyRemind notifyRemind);
}
