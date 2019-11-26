package com.chenze.sell.dto;

import com.chenze.sell.dataobject.OrderDetail;
import com.chenze.sell.enums.OrderStatusEnum;
import com.chenze.sell.enums.PayStatusEnum;
import com.chenze.sell.utils.EnumUtil;
import com.chenze.sell.utils.serializer.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Create by cz
 * Date： 2019/5/15 0015 下午 8:03
 */
@Data
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)//如果是空不返回
//@JsonInclude(JsonInclude.Include.NON_NULL)//如果是空不返回
public class OrderDTO {

    private String orderId;

    /*买家名字*/
    private String buyerName;

    /**买家电话*/
    private String buyerPhone;

    /**买家地址*/
    private String buyerAddress;

    /**买家微信openid*/
    private String buyerOpenid;

    /**订单总金额*/
    private BigDecimal orderAmount;

    /**订单状态，默认为0新下单*/
    private Integer orderStatus;

    /**支付状态，默认为0未支付*/
    private Integer payStatus;

    /**创建时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

    //json忽略传参
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }

}
