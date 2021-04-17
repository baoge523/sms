package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.ApplyEntity;
import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IApplyService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/apply")
public class ApplyController {

    @Autowired
    private IApplyService applyService;

    @PostMapping("/add")
    public void insert(@RequestBody ApplyEntity apply) {
        log.info("/uiapi/v1/apply/add param = [{}]", JSONObject.toJSONString(apply));
        applyService.insert(apply);
    }
    @PutMapping("/update")
    public ApplyEntity update(@RequestBody ApplyEntity apply) {
        log.info("/uiapi/v1/apply/update param = [{}]", JSONObject.toJSONString(apply));
        applyService.update(apply);
        return applyService.getById(apply.getId());
    }

    @DeleteMapping("/delete")
    public void delete(Set<Integer> ids) {
        log.info("/uiapi/v1/apply/update param = [{}]", JSONObject.toJSONString(ids));
        applyService.delete(ids);
    }

    @GetMapping("/detail/{id}")
    public ApplyEntity getById(@PathVariable("id") Integer id) {
        log.info("/uiapi/v1/apply/detail/{id} param = [{}]", id);
        return applyService.getById(id);
    }
    @PostMapping("/list")
    public Pair<List<ApplyEntity>,Long> list(@RequestBody QueryParam param){
        log.info("/uiapi/v1/apply/list param = [{}]", JSONObject.toJSONString(param));
        return applyService.list(param);
    }
}
