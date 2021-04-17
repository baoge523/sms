package com.manage.sys.sms.api.entity.query;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 请求参数
 */
@Data
public class QueryParam {

    private String id;
    private String code;
    private String name;

    private int pageNumber = 1;

    private int pageSize = 99999;
    /**
     * 其他条件
     */
    private Map<String,Object> conditions = new HashMap<>();

    public QueryParam addCondition(String key,Object value) {
        this.conditions.put(key,value);
        return this;
    }

}
