package com.manage.sys.sms.api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class MessageEntity extends BaseEntity {


    private String header;

    private String content;

    private int level = Level.GENERAL.getLevel();

    /**
     * 0 保存未发送
     * 1 已发送
     */
    private int status = 0;
    /**
     * 0 未读
     * 1 已读
     */
    private int readStatus;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8", locale = "zh")
    private Date sendTime;

}
