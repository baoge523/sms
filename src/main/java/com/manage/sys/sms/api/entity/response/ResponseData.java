package com.manage.sys.sms.api.entity.response;

import lombok.Data;

@Data
public class ResponseData<T> {
    private int code;
    private String message;
    private T data;
}
