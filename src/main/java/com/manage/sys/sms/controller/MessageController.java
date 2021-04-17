package com.manage.sys.sms.controller;

import com.alibaba.fastjson.JSONObject;
import com.manage.sys.sms.api.entity.MessageEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IMessageService;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/uiapi/v1/message")
public class MessageController {

    @Autowired
    private IMessageService messageService;

    @PostMapping("/add")
    public void insert(@RequestBody MessageEntity message) {
        log.info("/uiapi/v1/message/add param = [{}]", JSONObject.toJSONString(message));
        messageService.insert(message);
    }
    @PutMapping("/update")
    public MessageEntity update(@RequestBody MessageEntity message) {
        log.info("/uiapi/v1/message/update param = [{}]", JSONObject.toJSONString(message));
        messageService.update(message);
        return messageService.getById(message.getId());
    }

    @PutMapping("/update/relation")
    public void updateRelation(@RequestParam("userId") Integer userId,@RequestParam("messageId") Integer messageId) {
        messageService.updateRelation(userId,messageId);
    }

    @PostMapping("/send")
    public void send(@RequestBody MessageEntity message){
        log.info("/uiapi/v1/message/send param = [{}]", JSONObject.toJSONString(message));
        messageService.sendMessage(message);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Set<Integer> ids) {
        log.info("/uiapi/v1/message/update param = [{}]", JSONObject.toJSONString(ids));
        messageService.delete(ids);
    }

    @GetMapping("/detail/{id}")
    public MessageEntity getById(@PathVariable("id") Integer id) {
        log.info("/uiapi/v1/message/detail/{id} param = [{}]", id);
        return messageService.getById(id);
    }
    @PostMapping("/list")
    public Pair<List<MessageEntity>,Long> list(@RequestBody QueryParam param){
        log.info("/uiapi/v1/message/list param = [{}]", JSONObject.toJSONString(param));
        return messageService.list(param);
    }

    @PostMapping("/list/user")
    public Pair<List<MessageEntity>,Long> listByUserId(@RequestBody QueryParam param){
        log.info("/uiapi/v1/message/list param = [{}]", JSONObject.toJSONString(param));
        return messageService.listByUserId(param);
    }
}
