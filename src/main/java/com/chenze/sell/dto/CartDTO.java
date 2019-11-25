package com.chenze.sell.dto;

import lombok.Data;

/**
 * 购物车
 * Create by cz
 * Date： 2019/5/15 0015 下午 9:13
 */
@Data
public class CartDTO {

    /**商品id*/
    private String productId;

    /**商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
