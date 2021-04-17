package com.manage.sys.sms.common;

import com.manage.sys.sms.api.entity.AuthenticationSession;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 管理sessionId
 */
@Component
public class SessionIDCacheManage {

    private Map<String, AuthenticationSession> sessionCache = new ConcurrentHashMap<>();

    public AuthenticationSession obtain(String sessionId){
        return sessionCache.get(sessionId);
    }

    public void put(String sessionId,AuthenticationSession session){
        sessionCache.put(sessionId,session);
    }

    public boolean remove(String sessionId) {
        sessionCache.remove(sessionId);
        return true;
    }

}
