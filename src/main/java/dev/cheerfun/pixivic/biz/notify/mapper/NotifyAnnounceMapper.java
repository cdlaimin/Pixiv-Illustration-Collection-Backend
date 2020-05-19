package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifyAnnounce;
import org.apache.ibatis.annotations.Mapper;

/**
 *  * @Description TODO
 *  * @Classname NotifyAnnounceMapper
 *  * @Author fangzhou
 *  * @Date 2020/5/19 2:57 下午
 *  * @Version V1.0
 *  
 */
@Mapper
public interface NotifyAnnounceMapper {
    void save(NotifyAnnounce notifyAnnounce);
}
