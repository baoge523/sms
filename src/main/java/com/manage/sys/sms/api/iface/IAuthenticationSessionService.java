package com.manage.sys.sms.api.iface;

import com.manage.sys.sms.api.entity.AuthenticationSession;

/**
 * 认证的session管理
 *
 * 即：通过sessionId 换取身份认证信息
 *
 */
public interface IAuthenticationSessionService {


    AuthenticationSession getSessionInfo(String sessionId);


}
