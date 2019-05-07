package com.chenze.sell.service;

import com.chenze.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * Created by cz
 * Date: 2019/5/3  16:09
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);


}
