package com.chenze.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by cz
 * Date: 2019/5/4  14:53
 * 订单主表
 */
@Entity
@DynamicUpdate
@Data
public class OrderMaster {

    @Id
    private String orderId;

    /*买家名字*/
    private String buyerName;

    /**买家电话*/
    private String buyerPhone;

    /**买家地址*/
    private String buyerAdress;

    /**买家微信openid*/
    private String buyerOpenid;

    /**订单总金额*/
    private BigDecimal orderAmount;

    /**订单状态，默认为新下单*/
    private int orderStatus;

    /**支付状态，默认未支付*/
    private int payStatus;

}
