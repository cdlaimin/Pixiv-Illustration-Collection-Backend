package dev.cheerfun.pixivic.biz.notify.mapper;

import dev.cheerfun.pixivic.biz.notify.po.NotifyAnnounce;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    @Insert({
                "    <script>\n" +
                "      insert into notify_announce\n" +
                "      <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n" +
                "        <if test=\"notifyAnnounce.notifyAnnounceId != null\">\n" +
                "          notify_announce_id,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.notifyType != null\">\n" +
                "          notify_type,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderId != null\">\n" +
                "          sender_id,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderName != null\">\n" +
                "          sender_name,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderAction != null\">\n" +
                "          sender_action,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectType != null\">\n" +
                "          object_type,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectId != null\">\n" +
                "          object_id,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectTitle != null\">\n" +
                "          object_title,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectContent != null\">\n" +
                "          object_content,\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.createDate != null\">\n" +
                "          create_date,\n" +
                "        </if>\n" +
                "      </trim>\n" +
                "      <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n" +
                "        <if test=\"notifyAnnounce.notifyAnnounceId != null\">\n" +
                "          #{notifyAnnounce.notifyAnnounceId},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.notifyType != null\">\n" +
                "          #{notifyAnnounce.notifyType},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderId != null\">\n" +
                "          #{notifyAnnounce.senderId},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderName != null\">\n" +
                "          #{notifyAnnounce.senderName},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.senderAction != null\">\n" +
                "          #{notifyAnnounce.senderAction},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectType != null\">\n" +
                "          #{notifyAnnounce.objectType},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectId != null\">\n" +
                "          #{notifyAnnounce.objectId},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectTitle != null\">\n" +
                "          #{notifyAnnounce.objectTitle},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.objectContent != null\">\n" +
                "          #{notifyAnnounce.objectContent},\n" +
                "        </if>\n" +
                "        <if test=\"notifyAnnounce.createDate != null\">\n" +
                "          #{notifyAnnounce.createDate},\n" +
                "        </if>\n" +
                "      </trim>\n" +
                "    </script>"
    })
    void save(@Param("notifyAnnounce") NotifyAnnounce notifyAnnounce);
}
