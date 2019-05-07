package com.chenze.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by cz
 * Date: 2019/5/4  20:56
 * 订单明细表
 */
@Entity
@DynamicUpdate
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String orderId;

    private String productId;

    /**商品名称*/
    private String productName;

    /**当前价格，单位分*/
    private BigDecimal productPrice;

    /**数量*/
    private int productQuantity;

    /**小图*/
    private String productIcon;
}
