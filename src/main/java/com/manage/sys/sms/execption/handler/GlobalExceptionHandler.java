package com.manage.sys.sms.execption.handler;

import com.manage.sys.sms.api.entity.response.ResponseData;
import com.manage.sys.sms.execption.CodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<ResponseData<String>> handleAllException(Exception e) {
        if (e instanceof CodeException) {
            return handlerCodeException((CodeException) e);
        }
        return handlerException(e);
    }

    private ResponseEntity<ResponseData<String>> handlerCodeException(CodeException e) {
        ResponseData<String> data = new ResponseData<>();
        data.setCode(e.getCode());
        data.setMessage(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.valueOf(e.getCode()));
    }

    private ResponseEntity<ResponseData<String>> handlerException(Exception e) {
        ResponseData<String> data = new ResponseData<>();
        data.setCode(500);
        data.setMessage(e.getMessage());
        return new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
