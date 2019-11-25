package com.chenze.sell.convertor;

import com.chenze.sell.dataobject.OrderDetail;
import com.chenze.sell.dto.OrderDTO;
import com.chenze.sell.enums.ResultEnum;
import com.chenze.sell.exception.SellException;
import com.chenze.sell.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by cz
 * Date： 2019/5/16 0016 下午 9:46
 */
@Slf4j
public class OrderForm2OrderDTOConvertor {

    public static OrderDTO convert(OrderForm orderForm){

        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e){
            log.error("【对象转换错误，string={}】",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);


        return orderDTO;
    }
}
