package com.chenze.sell.controller;

import com.chenze.sell.VO.ProductInfoVO;
import com.chenze.sell.VO.ProductVO;
import com.chenze.sell.VO.ResultVO;
import com.chenze.sell.dataobject.ProductCategory;
import com.chenze.sell.dataobject.ProductInfo;
import com.chenze.sell.service.CategoryService;
import com.chenze.sell.service.ProductService;
import com.chenze.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * Created by cz
 * Date: 2019/5/5  0:07
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductorController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    /**
     * unless跟condition都是满足条件缓存，unless是结果满足条件（正确的缓存），condition是入参满足条件
     * @return
     */
    @GetMapping("/list")
    @Cacheable(cacheNames = "product", key = "123", unless = "#result.getCode() != 0")
    public ResultVO list(){
        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2.查询类目（一次性查询）
//        List<Integer> categoryTypeList = new ArrayList<Integer>();
        //传统方法
//        for(ProductInfo productInfo : productInfoList){
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法（java8,lambda）
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for(ProductInfo productInfo : productInfoList){
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //把productInfo的字段复制到productInfoVO
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        //成功
        return ResultVOUtil.success(productVOList);

    }


}
