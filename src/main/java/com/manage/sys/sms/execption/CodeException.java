package com.manage.sys.sms.execption;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 代码级别异常
 */
@Data
public class CodeException extends RuntimeException {

    private int code;

    public CodeException(HttpStatus status,String message) {
        // 提示消息
        super(message == null ? status.getReasonPhrase() : message);
        // 状态码
        this.code = status.value();
    }

}
