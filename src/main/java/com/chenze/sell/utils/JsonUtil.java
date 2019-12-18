package com.chenze.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Create by cz
 * Date： 2019/12/11 17:11
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
