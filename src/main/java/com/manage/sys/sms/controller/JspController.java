package com.manage.sys.sms.controller;

import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IBazaarService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class JspController {
    @Autowired
    private IBazaarService bazaarService;

    @RequestMapping("/login")
    public String index(){
        return "login";
    }
    @RequestMapping("/dologin")
    public String login(String username, String password, HttpServletRequest request) {
      log.info("current info username = {}, password = {}",username,password);
      request.getSession().setAttribute("name",username);
      return "main";
    }

    @RequestMapping("/bazaar/list")
    public String bazaars(HttpServletRequest request) {
        Pair<List<BazaarEntity>, Long> list = bazaarService.list(new QueryParam());
        request.setAttribute("bazaar",list.getFirst());
        return "bazaar";
    }

}
