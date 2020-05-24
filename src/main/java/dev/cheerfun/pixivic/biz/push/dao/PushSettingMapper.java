package dev.cheerfun.pixivic.biz.push.dao;

import dev.cheerfun.pixivic.biz.push.po.PushSetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *  * @Description TODO
 *  * @Classname PushSettingDao
 *  * @Author fangzhou
 *  * @Date 2020/5/24 3:36 下午
 *  * @Version V1.0
 *  
 */
@Mapper
public interface PushSettingMapper {

    @Select("select * from push_setting where object_type = #{objectType}, notify_action = #{notifyAction}")
    PushSetting queryPushSetting(String objectType, String notifyAction);
}
