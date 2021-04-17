package com.manage.sys.sms.api.iface.service;

import com.manage.sys.sms.api.entity.query.QueryParam;
import com.manage.sys.sms.sdk.Pair;

import java.util.List;
import java.util.Set;

public interface IBaseBusinessInterface<T> {

    int insert(T data);

    void update(T data);

    void delete(Set<Integer> ids);

    T getById(Integer id);

    Pair<List<T>,Long> list(QueryParam param);
}
