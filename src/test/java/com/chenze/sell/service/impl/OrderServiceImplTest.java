package com.chenze.sell.service.impl;

import com.chenze.sell.dataobject.OrderDetail;
import com.chenze.sell.dto.CartDTO;
import com.chenze.sell.dto.OrderDTO;
import com.chenze.sell.enums.OrderStatusEnum;
import com.chenze.sell.enums.PayStatusEnum;
import com.chenze.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Create by cz
 * Date： 2019/5/15 0015 下午 9:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String buyerOpenid = "110110";

    private final String orderId = "1557929412537809191";

    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName("噶地方");
        orderDTO.setBuyerAddress("北京");
        orderDTO.setBuyerPhone("1321544651");
        orderDTO.setBuyerOpenid(buyerOpenid);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail o1 = new OrderDetail();
        o1.setProductId("1224578");
        o1.setProductQuantity(1);


        OrderDetail o2 = new OrderDetail();
        o2.setProductId("1234578");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);


        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO result = orderService.findOne(orderId);
        log.info("[查询单个订单]result={}",result);
        Assert.assertEquals(orderId,result.getOrderId());
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenid,request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {

        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISHED.getCode(),result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne(orderId);
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(),result.getPayStatus());
    }

    @Test
    public void list(){
        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        Assert.assertTrue("查询所有的订单列表",orderDTOPage.getTotalElements() > 0);
    }
}