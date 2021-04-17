package com.manage.sys.sms.api.entity;

import lombok.Data;

/**
 * 用户
 */
@Data
public class UserEntity extends BaseEntity {
    private String password;

    private String phone;

    private String email;

    private String idCard;

    private boolean isManager;
}
