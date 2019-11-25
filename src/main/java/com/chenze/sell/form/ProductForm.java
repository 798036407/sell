package com.chenze.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Create by cz
 * Date： 2019/6/23 0023 下午 5:51
 */
@Data
public class ProductForm {

    private String productId;

    /**名字*/
    private String productName;

    /**单价*/
    private BigDecimal productPrice;

    /**库存*/
    private Integer productStock;

    /**描述*/
    private String productDescription;

    /**小图*/
    private String ProductIcon;

    /**状态，0正常1下架*/
    private Integer productStatus;

    /**类目编号*/
    private Integer categoryType;
}
