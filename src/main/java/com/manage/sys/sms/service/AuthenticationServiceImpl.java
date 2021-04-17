package com.manage.sys.sms.service;

import com.manage.sys.sms.api.entity.AccessUser;
import com.manage.sys.sms.api.entity.AuthenticationInfo;
import com.manage.sys.sms.api.entity.AuthenticationSession;
import com.manage.sys.sms.api.entity.UserEntity;
import com.manage.sys.sms.api.iface.IAuthentication;
import com.manage.sys.sms.api.iface.service.IUserService;
import com.manage.sys.sms.common.SessionIDCacheManage;
import com.manage.sys.sms.execption.CodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.UUID;

@Service
@Slf4j
public class AuthenticationServiceImpl implements IAuthentication {

    @Autowired
    private IUserService userService;

    @Autowired
    private SessionIDCacheManage cacheManage;

    @Override
    public AccessUser login(AccessUser accessUser, HttpServletRequest request) {
        UserEntity userEntity = doLogin(accessUser.getUsername(), accessUser.getPassword());
        String token = cacheAuthenticationInfo(userEntity, request);
        accessUser.setUserId(userEntity.getId());
        accessUser.setPassword("");
        accessUser.setToken(token);
        accessUser.setUserType(userEntity.isManager() ? "admin" : "user");
        accessUser.setSessionId(request.getSession().getId());
        accessUser.setIdCard(userEntity.getIdCard());
        return accessUser;
    }

    private UserEntity doLogin(String username, String password) {
        UserEntity userInfo= userService.getUserByUsername(username);
        if (userInfo == null) {
            log.error("not find user info by username = [{}]",username);
            throw new CodeException(HttpStatus.FORBIDDEN,"用户名或密码错误");
        }
        String dbPassword = userInfo.getPassword();
        if (!dbPassword.equals(password)) {
            throw new CodeException(HttpStatus.FORBIDDEN,"用户名或密码错误");
        }
        return userInfo;
    }

    private String cacheAuthenticationInfo( UserEntity user,HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        AuthenticationSession authenticationSession = new AuthenticationSession();
        authenticationSession.setUserId(user.getId());
        authenticationSession.setUsername(user.getCode());
        authenticationSession.setSessionId(sessionId);
        authenticationSession.setToken(generateToken());
        cacheManage.put(sessionId,authenticationSession);
        return authenticationSession.getToken();
    }

    /**
     * 生成token
     * @return
     */
    private String generateToken() {
        return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());
    }


    @Override
    public boolean logout(String sessionId) {
        return cacheManage.remove(sessionId);
    }

    @Override
    public boolean authentication(AuthenticationInfo info) {
        String token = info.getToken();
        return false;
    }
}
