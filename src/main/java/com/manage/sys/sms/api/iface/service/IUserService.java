package com.manage.sys.sms.api.iface.service;

import com.manage.sys.sms.api.entity.UserEntity;

public interface IUserService extends IBaseBusinessInterface<UserEntity> {

    UserEntity getUserByUsername(String username);

}
