package com.chenze.sell.service;

import com.chenze.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * 支付
 * Create by cz
 * Date： 2019/12/11 11:49
 */
public interface PayService {

    /**
     * 创建支付订单
     * @param orderDTO
     * @return
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信异步通知
     * @param notifyData
     * @return PayResponse
     */
    PayResponse notify(String notifyData);

    /**
     * 退款
     * @param orderDTO
     * @return
     */
    RefundResponse refund(OrderDTO orderDTO);
}
