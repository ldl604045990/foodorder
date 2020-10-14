package com.foodorder.constant;

public enum DeleteFlag {

    DELETE_FALSE(0, "正常,启用"),

    DELETE_TRUE(1, "删除,禁用");

    private Integer key;

    private String value;

    private DeleteFlag(Integer key, String value) {
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
