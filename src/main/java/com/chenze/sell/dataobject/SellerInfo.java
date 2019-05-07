package com.chenze.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 卖家表
 * Created by cz
 * Date: 2019/5/4  21:03
 */
@Entity
@DynamicUpdate
@Data
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    /**微信openid*/
    private String openId;

}
