package com.chenze.sell.service.impl;

import com.chenze.sell.dto.OrderDTO;
import com.chenze.sell.service.OrderService;
import com.chenze.sell.service.PushMessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Create by cz
 * Date： 2019/12/16 16:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class PushMessageImplTest {

    @Autowired
    PushMessageService pushMessageService;

    @Autowired
    OrderService orderService;

    @Test
    public void orderStatus() {
        OrderDTO orderDTO = orderService.findOne("1576237738925986882");
        pushMessageService.orderStatus(orderDTO);
    }
}
