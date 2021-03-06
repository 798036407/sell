package com.chenze.sell.enums;

import lombok.Getter;

/**
 * Create by cz
 * Date： 2019/5/10 0010 下午 10:38
 */
@Getter
public enum PayStatusEnum implements CodeEnum {

    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功")
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
