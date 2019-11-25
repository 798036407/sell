package com.chenze.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 订单表单验证
 * Create by cz
 * Date： 2019/5/16 0016 下午 9:24
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     * */
    @NotEmpty(message = "买家姓名必填")
    private String name;

    /**
     * 买家手机号
     * */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     * */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * openid
     * */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     * */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
