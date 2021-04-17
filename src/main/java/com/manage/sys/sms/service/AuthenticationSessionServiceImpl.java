package com.manage.sys.sms.service;

import com.manage.sys.sms.api.entity.AuthenticationSession;
import com.manage.sys.sms.api.iface.IAuthenticationSessionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class AuthenticationSessionServiceImpl implements IAuthenticationSessionService {


    private Map<String,AuthenticationSession> sessionCache = new ConcurrentHashMap<>();

    @Override
    public AuthenticationSession getSessionInfo(String sessionId) {
        return sessionCache.get(sessionId);
    }
}
