package com.chenze.sell.utils;

import java.util.Random;

/**
 * Create by cz
 * Date： 2019/5/15 0015 下午 8:51
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        //生成六位随机数
        Integer number = random.nextInt(900000)+100000;
        return System.currentTimeMillis() + String.valueOf(number);


    }
}
