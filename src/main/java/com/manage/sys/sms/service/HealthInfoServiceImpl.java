package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.HealthInfo;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IHealthInfoService;
import com.manage.sys.sms.dao.IHealthInfoMapper;
import com.manage.sys.sms.sdk.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@Service
public class HealthInfoServiceImpl implements IHealthInfoService {

    @Autowired
    private IHealthInfoMapper healthInfoMapper;

    @Override
    public HealthInfo obtainByUserId(Integer userId) {
        return healthInfoMapper.obtainByUserId(userId);
    }

    @Override
    public int insert(HealthInfo data) {
        healthInfoMapper.insert(data);
        return 0;
    }

    @Override
    public void update(HealthInfo data) {
        healthInfoMapper.update(data);
    }

    @Override
    public void delete(Set<Integer> ids) {
        healthInfoMapper.delete(ids);
    }

    @Override
    public HealthInfo getById(Integer id) {
        return healthInfoMapper.getById(id);
    }

    @Override
    public Pair<List<HealthInfo>, Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<HealthInfo> list = healthInfoMapper.list(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }
}
