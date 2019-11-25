package com.chenze.sell.utils;

import com.chenze.sell.enums.CodeEnum;

/**
 * Create by cz
 * Date： 2019/6/10 0010 下午 11:55
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if(code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
