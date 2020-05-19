package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifyRemind;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    @Insert({
                    "    <script>\n" +
                    "      insert into notify_announce\n" +
                    "      <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
                    "        <if test=\"notifyRemind.notifyRemindId != null\">\n" +
                    "          notify_remind_id,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.notifyType != null\">\n" +
                    "          notify_type,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderId != null\">\n" +
                    "          sender_id,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderName != null\">\n" +
                    "          sender_name,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderAction != null\">\n" +
                    "          sender_action,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectType != null\">\n" +
                    "          object_type,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectId != null\">\n" +
                    "          object_id,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectTitle != null\">\n" +
                    "          object_title,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectContent != null\">\n" +
                    "          object_content,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.actionObjectId != null\">\n" +
                    "          action_object_id,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.actionObjectContent != null\">\n" +
                    "          action_object_content,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.recipientId != null\">\n" +
                    "          recipient_id,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.createDate != null\">\n" +
                    "          create_date,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.readStatus != null\">\n" +
                    "          read_status,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.readAt != null\">\n" +
                    "          read_at,\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.notifyAnnounceId != null\">\n" +
                    "          notify_announce_id,\n" +
                    "        </if>\n" +
                    "      </trim>\n" +
                    "      <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
                    "        <if test=\"notifyRemind.notifyRemindId != null\">\n" +
                    "          #{notifyRemind.notifyRemindId},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.notifyType != null\">\n" +
                    "          #{notifyRemind.notifyType},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderId != null\">\n" +
                    "          #{notifyRemind.senderId},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderName != null\">\n" +
                    "          #{notifyRemind.senderName},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.senderAction != null\">\n" +
                    "          #{notifyRemind.senderAction},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectType != null\">\n" +
                    "          #{notifyRemind.objectType},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectId != null\">\n" +
                    "          #{notifyRemind.objectId},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectTitle != null\">\n" +
                    "          #{notifyRemind.objectTitle},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.objectContent != null\">\n" +
                    "          #{notifyRemind.objectContent},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.actionObjectId != null\">\n" +
                    "          #{notifyRemind.actionObjectId},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.actionObjectContent != null\">\n" +
                    "          #{notifyRemind.actionObjectContent},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.recipientId != null\">\n" +
                    "          #{notifyRemind.recipientId},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.createDate != null\">\n" +
                    "          #{notifyRemind.createDate},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.readStatus != null\">\n" +
                    "          #{notifyRemind.readStatus},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.readAt != null\">\n" +
                    "          #{notifyRemind.readAt},\n" +
                    "        </if>\n" +
                    "        <if test=\"notifyRemind.notifyAnnounceId != null\">\n" +
                    "          #{notifyRemind.notifyAnnounceId},\n" +
                    "        </if>\n" +
                    "      </trim>\n" +
                    "    </script>"
    })
    void save(@Param("notifyRemind") NotifyRemind notifyRemind);
}
