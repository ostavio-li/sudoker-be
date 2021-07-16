package com.carlosli.sudoker.product.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author lijiancheng
 * @date 2021/7/16
 */
public enum ProductType {

    BOOK(1, "书籍"),
    MERCH(2, "周边");

    // 代码
    @EnumValue
    private final Integer code;
    // 描述
    @JsonValue
    private final String description;

    ProductType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
