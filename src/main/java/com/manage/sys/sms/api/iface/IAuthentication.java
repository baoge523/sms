package com.manage.sys.sms.api.iface;

import com.manage.sys.sms.api.entity.AccessUser;
import com.manage.sys.sms.api.entity.AuthenticationInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * 认证接口
 */
public interface IAuthentication {

    AccessUser login(AccessUser accessUser, HttpServletRequest request);

    boolean logout(String sessionId);

    boolean authentication(AuthenticationInfo info);
}
