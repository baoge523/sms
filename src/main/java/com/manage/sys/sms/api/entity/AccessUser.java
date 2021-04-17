package com.manage.sys.sms.api.entity;

import lombok.Data;

@Data
public class AccessUser {
    private Integer userId;
    private String username;
    private String password;
    private String verifyCode;
    private String token;
    private String sessionId;
    private String idCard;
    // -----
    private String userType; // admin or user
}
