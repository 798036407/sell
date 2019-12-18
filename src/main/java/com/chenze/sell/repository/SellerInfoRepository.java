package com.chenze.sell.repository;

import com.chenze.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Create by cz
 * Date： 2019/12/7 23:54
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {
    SellerInfo findByOpenId(String openId);
}
