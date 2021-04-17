package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.HealthInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IHealthInfoMapper extends IBaseMapper<HealthInfo> {

    HealthInfo obtainByUserId(Integer userId);
}
