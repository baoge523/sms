package com.manage.sys.sms.api.iface.service;

import com.manage.sys.sms.api.entity.MessageEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.sdk.Pair;

import java.util.List;

public interface IMessageService extends IBaseBusinessInterface<MessageEntity> {
    /**
     * 发送消息
     * @param message
     */
    void sendMessage(MessageEntity message);

    Pair<List<MessageEntity>,Long> listByUserId(QueryParam param);

    void updateRelation(Integer userId,Integer messageId);

}
