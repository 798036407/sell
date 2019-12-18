package com.chenze.sell.service.impl;

import com.chenze.sell.dataobject.SellerInfo;
import com.chenze.sell.repository.SellerInfoRepository;
import com.chenze.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create by cz
 * Date： 2019/12/8 13:51
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenId(String openId) {
        return repository.findByOpenId(openId);
    }
}
