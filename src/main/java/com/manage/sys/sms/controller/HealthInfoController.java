package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.HealthInfo;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IBazaarService;
import com.manage.sys.sms.api.iface.service.IHealthInfoService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/health")
public class HealthInfoController {

    @Autowired
    private IHealthInfoService healthInfoService;

    @PostMapping("/add")
    public void insert(@RequestBody HealthInfo info) {
        log.info("/uiapi/v1/health/add param = [{}]", JSONObject.toJSONString(info));
        healthInfoService.insert(info);
    }
    @PutMapping("/update")
    public HealthInfo update(@RequestBody HealthInfo info) {
        log.info("/uiapi/v1/health/update param = [{}]", JSONObject.toJSONString(info));
        healthInfoService.update(info);
        return healthInfoService.getById(info.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Set<Integer> ids) {
        log.info("/uiapi/v1/health/delete param = [{}]", JSONObject.toJSONString(ids));
        healthInfoService.delete(ids);
    }

    @GetMapping("/detail/{id}")
    public HealthInfo getById(@PathVariable("id") Integer id) {
        log.info("/uiapi/v1/health/detail/{id} param = [{}]", id);
        return healthInfoService.getById(id);
    }
    @GetMapping("/obtain/detail/{userId}")
    public HealthInfo obtainByUserId(@PathVariable("userId") Integer userId) {
        log.info("/uiapi/v1/health/obtain/detail/{userId} param = [{}]", userId);
        return healthInfoService.obtainByUserId(userId);
    }


    @PostMapping("/list")
    public Pair<List<HealthInfo>,Long> list(@RequestBody QueryParam param){
        log.info("/uiapi/v1/health/list param = [{}]", JSONObject.toJSONString(param));
        return healthInfoService.list(param);
    }
}
