package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.StallEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IStallService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/stall")
public class StallController {

    @Autowired
    private IStallService stallService;

    @PostMapping("/add")
    public void insert(@RequestBody StallEntity stall) {
        log.info("/uiapi/v1/stall/add param = [{}]", JSONObject.toJSONString(stall));
        stallService.insert(stall);
    }
    @PutMapping("/update")
    public StallEntity update(@RequestBody StallEntity stall) {
        log.info("/uiapi/v1/stall/update param = [{}]", JSONObject.toJSONString(stall));
        stallService.update(stall);
        return stallService.getById(stall.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Set<Integer> ids) {
        log.info("/uiapi/v1/stall/update param = [{}]", JSONObject.toJSONString(ids));
        stallService.delete(ids);
    }

    @GetMapping("/detail/{id}")
    public StallEntity getById(@PathVariable("id") Integer id) {
        log.info("/uiapi/v1/stall/detail/{id} param = [{}]", id);
        return stallService.getById(id);
    }
    @PostMapping("/list")
    public Pair<List<StallEntity>,Long> list(@RequestBody QueryParam param){
        log.info("/uiapi/v1/stall/list param = [{}]", JSONObject.toJSONString(param));
        return stallService.list(param);
    }
}
