package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.MessageEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IUserMessageMapper {

    void insertRelation(@Param("userId") Integer userId, @Param("messageId") Integer messageId);

    void insertRelationBatch(@Param("userIds") List<Integer> userIds, @Param("messageId") Integer messageId);

    List<MessageEntity> listMessagesByUserId(QueryParam param);

    /**
     * 将信息设为已读
     * @param userId
     * @param messageId
     */
    void updateRelation(@Param("userId") Integer userId, @Param("messageId") Integer messageId);


}
