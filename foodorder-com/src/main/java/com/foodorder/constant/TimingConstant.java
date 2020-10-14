package com.foodorder.constant;

public enum TimingConstant {

    /** 登录存在时间 */
    LOGIN_EX_TIMING(3600, "登录存在时间");


    private Integer key;

    private String value;

    private TimingConstant(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getKey() {
        return key;
    }
}
