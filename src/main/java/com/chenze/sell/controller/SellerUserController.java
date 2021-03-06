package com.chenze.sell.controller;

import com.chenze.sell.config.ProjectUrlConfig;
import com.chenze.sell.constant.CookieConstant;
import com.chenze.sell.constant.RedisConstant;
import com.chenze.sell.dataobject.SellerInfo;
import com.chenze.sell.enums.ResultEnum;
import com.chenze.sell.service.SellerService;
import com.chenze.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 卖家用户
 * Create by cz
 * Date： 2019/12/15 20:35
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    /**
     * 登录
     * @param openid
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse response,
                              Map<String,Object> map) {

        //1、openid跟数据库里的匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenId(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        //2、设置token至redis
        String token = UUID.randomUUID().toString();
        //失效时间
        Integer expire = RedisConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);

        //3、设置token至cookie
        CookieUtil.set(response, CookieConstant.Token, token, expire);
        //登录成功跳转
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Map<String,Object> map) {
        //1、从cookie中查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.Token);
        if (cookie != null) {
            //2、清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3、清除cookie
            CookieUtil.set(response, CookieConstant.Token, null, 0);
        }

        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);



    }
}
