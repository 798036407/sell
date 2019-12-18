package com.chenze.sell.exception;

import com.chenze.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * Create by cz
 * Date： 2019/5/15 0015 下午 8:26
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
