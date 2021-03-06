package com.chenze.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Create by cz
 * Date： 2019/5/9 0009 下午 10:12
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -2636038699334800996L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
