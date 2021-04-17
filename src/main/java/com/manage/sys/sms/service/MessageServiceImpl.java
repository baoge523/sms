package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.MessageEntity;
import com.manage.sys.sms.api.entity.UserEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IMessageService;
import com.manage.sys.sms.api.iface.service.IUserService;
import com.manage.sys.sms.dao.IMessageMapper;
import com.manage.sys.sms.dao.IUserMapper;
import com.manage.sys.sms.dao.IUserMessageMapper;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MessageServiceImpl implements IMessageService {

    @Autowired
    private IMessageMapper messageMapper;

    @Autowired
    private IUserMessageMapper userMessageMapper;

    @Autowired
    private IUserMapper userMapper;


    @Override
    @Transactional
    public void sendMessage(MessageEntity message) {
        message.setStatus(1); // 发送状态
        message.setSendTime(new Date());
        if (message.getId() == null) {
            insert(message);
        } else {
            update(message);
        }
        Integer messageId = message.getId();
        List<UserEntity> list = userMapper.list(null);
        List<Integer> ids = list.stream().map(user -> user.getId()).collect(Collectors.toList());
        userMessageMapper.insertRelationBatch(ids,messageId);
    }

    @Override
    public Pair<List<MessageEntity>, Long> listByUserId(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<MessageEntity> list = userMessageMapper.listMessagesByUserId(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }

    @Override
    public void updateRelation(Integer userId, Integer messageId) {
        userMessageMapper.updateRelation(userId, messageId);
    }

    @Override
    public int insert(MessageEntity data) {
        return messageMapper.insert(data);
    }

    @Override
    public void update(MessageEntity data) {
        messageMapper.update(data);
    }

    @Override
    public void delete(Set<Integer> ids) {
        messageMapper.delete(ids);
    }

    @Override
    public MessageEntity getById(Integer id) {
        return messageMapper.getById(id);
    }

    @Override
    public Pair<List<MessageEntity>, Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<MessageEntity> list = messageMapper.list(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }
}
