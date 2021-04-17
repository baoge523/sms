package com.manage.sys.sms.api.iface.service;

import com.manage.sys.sms.api.entity.HealthInfo;

public interface IHealthInfoService extends IBaseBusinessInterface<HealthInfo> {

    HealthInfo obtainByUserId(Integer userId);

}
