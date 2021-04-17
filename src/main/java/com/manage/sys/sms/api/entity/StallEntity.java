package com.manage.sys.sms.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 摊位
 */
@Data
public class StallEntity extends BaseEntity {

    private Integer bazaarId;

    private Integer userId;

    private String username;

    private String bazaarName;

    /**
     * 面积
     */
    private String size;

    /**
     * 价格
     */
    private String price;

    /**
     * 租用时间-单位月
     */
    private Integer dateMonth;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date expiration;

    /**
     * 0 未租
     * 1 已租
     */
    private Integer status = 0;

}
