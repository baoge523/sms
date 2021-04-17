package com.manage.sys.sms.api.entity;

import lombok.Data;

/**
 * 市场
 */
@Data
public class BazaarEntity extends BaseEntity {
    private String phone;

    private String location;
    /**
     *  0 维护
     *  1 开放
     */
    private Integer status = 0;

    private String manager;

    private Integer sortNumber = 1;
}
