package com.manage.sys.sms.api.entity;

import lombok.Data;

/**
 * 认证信息
 */
@Data
public class AuthenticationInfo {


    private String username;

    private String password;

    private String token;
}
