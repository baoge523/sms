package com.manage.sys.sms.utils;

import java.util.Collection;

/**
 * 集合的工具类
 */
public class CollectionUtils {


    public static<T> boolean isEmpty(Collection<T> collection) {
       return collection == null || collection.isEmpty();
    }

    public static<T> boolean isNotEmpty(Collection<T> collection) {
        return !isEmpty(collection);
    }


}
