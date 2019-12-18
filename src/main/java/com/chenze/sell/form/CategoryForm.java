package com.chenze.sell.form;

import lombok.Data;

/**
 * Create by cz
 * Date： 2019/12/6 12:38
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /**类目名字*/
    private String categoryName;

    /**类目编号*/
    private Integer categoryType;
}
