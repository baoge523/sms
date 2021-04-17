package com.manage.sys.sms.api.entity;

import lombok.Data;

import java.util.List;

/**
 * 健康打卡
 */
@Data
public class HealthInfo extends BaseEntity {


    private Integer userId;

    private String username;

    private String idCard;

    /**
     * 过去14天是否与确诊病人、疑似病人、或无症状感染者接触
     */
    private Boolean isTouch = false;

    /**
     * 当前是否与居家隔离人员同居
     */
    private Boolean isLive = false;

    private Integer status = HealthStatus.NORMAL.getValue();

    /**
     * 当前症状（多选）
     *
     *  0 没有出现症状
     *  1 感冒症状、乏力、咳嗽、发烧、肌肉痛、头痛
     *  2 踹憋、呼吸急促
     *  3 恶心呕吐、腹泻
     *  4 心慌、胸闷
     *  5 结膜炎
     *  6 其他
     *
     *
     * 存入数据库的时候，需要通过mybatis的类型转换，将其转换字符串
     */
    private List<String> currentSymptom;

    /**
     * 当前体温
     */
    private String currentHeat;



}
