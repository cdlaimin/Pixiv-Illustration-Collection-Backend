package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifySetting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *  * @Description TODO
 *  * @Classname NotifySettingMapper
 *  * @Author fangzhou
 *  * @Date 2020/5/19 11:53 上午
 *  * @Version V1.0
 *  
 */
@Mapper
public interface NotifySettingMapper {

    @Select("select * from notify_setting")
    @Results({
            @Result(property = "notifySettingId", column = "notify_setting_id"),
            @Result(property = "objectType", column = "object_type"),
            @Result(property = "notifyAction", column = "notify_action"),
            @Result(property = "notifyType", column = "notify_type"),
            @Result(property = "whetherNotify", column = "whether_notify"),
            @Result(property = "whetherPush", column = "whether_push")
    })
    List<NotifySetting> queryNotifySetting();
}
