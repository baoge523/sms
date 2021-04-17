package com.manage.sys.sms.dao;

import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.sdk.Pair;

import java.util.List;
import java.util.Set;

public interface IBaseMapper<T> {
    int insert(T data);

    void update(T data);

    void delete(Set<Integer> ids);

    T getById(Integer id);

    List<T> list(QueryParam param);
}
