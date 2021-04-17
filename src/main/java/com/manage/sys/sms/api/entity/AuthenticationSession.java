package com.manage.sys.sms.api.entity;

import lombok.Data;

/**
 * 认证的session信息
 */
@Data
public class AuthenticationSession {

    private Integer userId;

    private String username;

    private String sessionId;

    private String token;
    /**
     * 失效时间
     */
    private long expireTime;

}
