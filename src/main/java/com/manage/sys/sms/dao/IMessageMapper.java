package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.MessageEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IMessageMapper extends IBaseMapper<MessageEntity> {
}
