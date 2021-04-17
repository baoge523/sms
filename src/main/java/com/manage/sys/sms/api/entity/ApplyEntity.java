package com.manage.sys.sms.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ApplyEntity extends BaseEntity {

    private Integer userId;

    private String username;

    private Integer stallId;
    /**
     * 摊位名称
     */
    private String stallName;

    /**
     * 市场id
     */
    private String bazaarId;
    /**
     * 市场名称
     */
    private String bazaarName;

    /**
     * 附带的消息
     */
    private String message;

    /**
     * 0 还没有处理
     * 1 成功
     * 2 失败
     */
    private Integer status = 0;
    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date handlerTime;

}
