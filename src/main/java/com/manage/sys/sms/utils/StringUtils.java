package com.manage.sys.sms.utils;

/**
 * String操作的工具类
 */
public class StringUtils {

    public static boolean isEmpty(String content) {
        if (content == null || "".equals(content.trim())) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String content) {
        return !isEmpty(content);
    }

}
