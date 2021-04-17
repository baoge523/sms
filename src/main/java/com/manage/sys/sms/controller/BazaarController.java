package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IBazaarService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/bazaar")
public class BazaarController {

    @Autowired
    private IBazaarService bazaarService;

    @PostMapping("/add")
    public void insert(@RequestBody BazaarEntity bazaar) {
        log.info("/uiapi/v1/bazaar/add param = [{}]", JSONObject.toJSONString(bazaar));
        bazaarService.insert(bazaar);
    }
    @PutMapping("/update")
    public BazaarEntity update(@RequestBody BazaarEntity bazaar) {
        log.info("/uiapi/v1/bazaar/update param = [{}]", JSONObject.toJSONString(bazaar));
        bazaarService.update(bazaar);
        return bazaarService.getById(bazaar.getId());
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Set<Integer> ids) {
        log.info("/uiapi/v1/bazaar/update param = [{}]", JSONObject.toJSONString(ids));
        bazaarService.delete(ids);
    }

    @GetMapping("/detail/{id}")
    public BazaarEntity getById(@PathVariable("id") Integer id) {
        log.info("/uiapi/v1/bazaar/detail/{id} param = [{}]", id);
        return bazaarService.getById(id);
    }
    @PostMapping("/list")
    public Pair<List<BazaarEntity>,Long> list(@RequestBody QueryParam param){
        log.info("/uiapi/v1/bazaar/list param = [{}]", JSONObject.toJSONString(param));
        return bazaarService.list(param);
    }










}
