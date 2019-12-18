package com.chenze.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Create by cz
 * Date： 2019/5/9 0009 下午 10:07
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = 7263613713816462432L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
