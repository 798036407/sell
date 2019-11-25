package com.chenze.sell.service;

import com.chenze.sell.dto.OrderDTO;

/**
 * 买家
 * Create by cz
 * Date： 2019/5/18 0018 上午 12:03
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid,String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid,String orderId);

}
