package com.chenze.sell.service;

import com.chenze.sell.dto.OrderDTO;

/**
 * 推送消息
 * Create by cz
 * Date： 2019/12/16 16:08
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
