package com.chenze.sell.service;

import com.chenze.sell.dataobject.ProductInfo;
import com.chenze.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品
 * Created by cz
 * Date: 2019/5/4  23:29
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**查询所有在架商品列表
     *
     * */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品列表
     * */
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);

}
