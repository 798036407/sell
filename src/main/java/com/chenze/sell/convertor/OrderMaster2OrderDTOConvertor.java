package com.chenze.sell.convertor;

import com.chenze.sell.dataobject.OrderMaster;
import com.chenze.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by cz
 * Date： 2019/5/15 0015 下午 10:39
 */
public class OrderMaster2OrderDTOConvertor {

    public static OrderDTO convert(OrderMaster orderMaster){

        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderMaster,orderDTO);

        return orderDTO;

    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
