package com.foodorder.constant;

public enum OrderUserType {

    SYSTEM_LOGIN(1, "系统管理员"),

    MERCHANT_LOGIN(2, "商户");

    private Integer key;

    private String value;

    private OrderUserType(Integer key, String value) {
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
