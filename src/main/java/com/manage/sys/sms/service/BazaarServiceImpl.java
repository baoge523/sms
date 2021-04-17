package com.manage.sys.sms.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.sys.sms.api.entity.BazaarEntity;
import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.api.iface.service.IBazaarService;
import com.manage.sys.sms.dao.IBazaarMapper;
import com.manage.sys.sms.sdk.Pair;
import com.manage.sys.sms.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Slf4j
@Service
public class BazaarServiceImpl implements IBazaarService{

    @Autowired
    private IBazaarMapper bazaarMapper;

    @Override
    public int insert(BazaarEntity data) {
        enrichData(data);
        return bazaarMapper.insert(data);
    }

    // todo 丰富创建者和更新者
    private void enrichData(BazaarEntity data) {
        if (StringUtils.isEmpty(data.getCode())) {
            data.setCode(UUID.randomUUID().toString());
        }
    }

    @Override
    public void update(BazaarEntity data) {
        bazaarMapper.update(data);

    }

    @Override
    public void delete(Set<Integer> ids) {
        bazaarMapper.delete(ids);
    }

    @Override
    public BazaarEntity getById(Integer id) {
        return bazaarMapper.getById(id);
    }

    @Override
    public Pair<List<BazaarEntity>, Long> list(QueryParam param) {
        PageHelper.startPage(param.getPageNumber(),param.getPageSize());
        List<BazaarEntity> list = bazaarMapper.list(param);
        PageInfo info = new PageInfo(list);
        return new Pair<>(list,info.getTotal());
    }
}
