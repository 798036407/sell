package com.chenze.sell.enums;

import lombok.Getter;

/**
 * Create by cz
 * Date： 2019/5/10 0010 下午 10:31
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //抽象到工具类了
    /*public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for(OrderStatusEnum orderStatusEnum: OrderStatusEnum.values()){
            if(orderStatusEnum.getCode().equals(code)){
                return orderStatusEnum;
            }
        }
        return null;
    }*/
}
