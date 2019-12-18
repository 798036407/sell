package com.chenze.sell.handler;

import com.chenze.sell.VO.ResultVO;
import com.chenze.sell.config.ProjectUrlConfig;
import com.chenze.sell.exception.SellException;
import com.chenze.sell.exception.SellerAuthorizeException;
import com.chenze.sell.utils.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理
 * Create by cz
 * Date： 2019/12/15 22:37
 */
@ControllerAdvice
public class SellerExceptionHandler {

    @Autowired
    ProjectUrlConfig projectUrlConfig;

    /**
     * 拦截登录异常ResponseStatus(HttpStatus.FORBIDDEN)是返回状态吗，通过枚举
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ModelAndView handlerAuthorizeException() {
        return new ModelAndView("redirect:"
        .concat(projectUrlConfig.getWechatOpenAuthorize())
        .concat("/sell/wechat/qrAuthorize")
        .concat("?returnUrl=")
        .concat(projectUrlConfig.getSell())
        .concat("/sell/seller/login"));
    }

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVO handlerSellException(SellException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }
}
