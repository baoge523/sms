package com.manage.sys.sms.controller;

import com.manage.sys.sms.api.entity.AccessUser;
import com.manage.sys.sms.api.entity.UserEntity;
import com.manage.sys.sms.api.iface.IAuthentication;
import com.manage.sys.sms.api.iface.service.IUserService;
import com.manage.sys.sms.execption.CodeException;
import com.manage.sys.sms.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 用户管理登录
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class ManageController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IAuthentication authenticationService;

    @PostMapping("/login")
    public AccessUser login(HttpServletRequest request, @RequestBody AccessUser accessUser) {
        log.info("/admin/login");
        check(accessUser);
        return authenticationService.login(accessUser,request);
    }

    @PostMapping("/logout")
    public boolean logout(HttpServletRequest request) {
        return authenticationService.logout(request.getSession(false).getId());
    }

    @GetMapping("/{username}")
    public UserEntity test(@PathVariable("username") String username,HttpServletRequest request) {
        UserEntity userByUsername = userService.getUserByUsername(username);
        String id = request.getSession().getId();
        System.out.println("-------------");
        System.out.println(id);
        System.out.println("==============");

        String loginIp = request.getHeader("X-Forwarded-For");
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            System.out.println("a");
            loginIp = request.getHeader("X-Real-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            System.out.println("b");
            loginIp = request.getHeader("Proxy-Client-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            System.out.println("c");
            loginIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            System.out.println("d");
            loginIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            System.out.println("e");
            loginIp = request.getRemoteAddr();
        }
        if("127.0.0.1".equals(loginIp)||"0:0:0:0:0:0:0:1".equals(loginIp)){
            //根据网卡取本机配置的IP
            InetAddress inet=null;
            try {
                inet = InetAddress.getLocalHost();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            loginIp= inet.getHostAddress();
        }
        System.out.println(loginIp);
        return  userByUsername;
    }

    private void check(AccessUser accessUser) {
        // 检查用户名和密码是否为空
        if (accessUser == null || StringUtils.isEmpty(accessUser.getUsername()) || StringUtils.isEmpty(accessUser.getPassword())) {
            throw new CodeException(HttpStatus.FORBIDDEN,"参数不正确");
        }
    }


}
