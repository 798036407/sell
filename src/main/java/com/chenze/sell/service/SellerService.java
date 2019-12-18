package com.chenze.sell.service;

import com.chenze.sell.dataobject.SellerInfo;

/**
 * 卖家端
 * Create by cz
 * Date： 2019/12/8 13:49
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @param openId
     * @return
     */
    SellerInfo findSellerInfoByOpenId(String openId);
}
