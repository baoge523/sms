package com.manage.sys.sms.api.entity;

/**
 * 消息等级
 */
public enum Level {
    /**
     * 重要
     */
    IMPORTANCE(3),
    /**
     * 中等
     */
    GENERAL_IMPORTANCE(2),

    /**
     * 一般
     */
    GENERAL(1);
    private int level;
    Level(int level) {
        this.level = level;
    }

    public int getLevel(){
        return level;
    }

    public Level format(int level) {
        Level[] values = Level.values();
        for (Level val : values) {
            if (val.level == level) {
                return val;
            }
        }
        throw new RuntimeException("level = "+ level + " format Level error");
    }


}
