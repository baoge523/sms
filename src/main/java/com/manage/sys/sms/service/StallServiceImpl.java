package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.StallEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IStallService;
import com.manage.sys.sms.dao.IStallMapper;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class StallServiceImpl implements IStallService {

    @Autowired
    private IStallMapper stallMapper;

    @Override
    public int insert(StallEntity data) {
        return stallMapper.insert(data);
    }

    @Override
    public void update(StallEntity data) {
        stallMapper.update(data);
    }

    @Override
    public void delete(Set<Integer> ids) {
        stallMapper.delete(ids);
    }

    @Override
    public StallEntity getById(Integer id) {
        return stallMapper.getById(id);
    }

    @Override
    public Pair<List<StallEntity>, Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<StallEntity> list = stallMapper.list(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }
}
