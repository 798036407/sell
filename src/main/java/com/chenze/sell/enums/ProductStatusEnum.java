package com.chenze.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * Created by cz
 * Date: 2019/5/4  23:38
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架")
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
