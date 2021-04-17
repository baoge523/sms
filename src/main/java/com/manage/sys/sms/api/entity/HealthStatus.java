package com.manage.sys.sms.api.entity;

import lombok.Getter;

/**
 * 当前状态
 *
 *   正常 0
 *   居家隔离医学观察 1
 *   集中隔离医学观察 2
 *   隔离治疗 3
 *   隔离治疗后出院 4
 *   其他 5
 *
 *
 */
public enum HealthStatus {

    NORMAL("正常",0),
    HOME_QUARANTINE("居家隔离医学观察",1),
    FOCUS_QUARANTINE("集中隔离医学观察",2),
    CURE("隔离治疗",3),
    CURE_FREE("隔离治疗后出院",4),
    OTHER("其他",5);


    private String name;

    @Getter
    private Integer value;

    HealthStatus(String name,Integer value) {
        this.name = name;
        this.value = value;
    }



}
