package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper extends IBaseMapper<UserEntity> {
    UserEntity getUserByUsername(String username);
}
