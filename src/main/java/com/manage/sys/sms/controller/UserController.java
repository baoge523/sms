package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.UserEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IUserService;
import com.manage.sys.sms.execption.CodeException;
import com.manage.sys.sms.sdk.Pair;
import com.manage.sys.sms.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @PostMapping("/register")
    public boolean register(@RequestBody UserEntity user) {
        log.info("/uiapi/v1/user/register param = [{}]", JSONObject.toJSONString(user));
        check(user);
        userService.insert(user);
        return true;
    }

    @PutMapping("/update")
    public UserEntity update(@RequestBody UserEntity user) {
        log.info("/uiapi/v1/user/update  param = [{}]",JSONObject.toJSONString(user));
        userService.update(user);
        return userService.getById(user.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Set<Integer> ids){
        log.info("/uiapi/v1/user/delete  param = [{}]",ids);
        userService.delete(ids);
    }

    @GetMapping("/get/{id}")
    public UserEntity getUserById(@PathVariable("id") Integer id){
        log.info("/uiapi/v1/user/get/{id}  param = [{}]",id);
        return userService.getById(id);
    }

    @PostMapping("/list")
    public Pair<List<UserEntity>, Long> listUser(@RequestBody QueryParam param) {
        log.info("/uiapi/v1/user/list  param = [{}]",JSONObject.toJSONString(param));
        return userService.list(param);
    }


    private void check(UserEntity user) {
        if (user == null || StringUtils.isEmpty(user.getCode())
                || StringUtils.isEmpty(user.getName()) || StringUtils.isEmpty(user.getPassword())) {
            log.error("register user missing required parameters");
            throw new CodeException(HttpStatus.FORBIDDEN,"缺少必要参数");
        }

    }


}
