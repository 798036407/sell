package com.chenze.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象
 * Create by cz
 * Date： 2019/5/9 0009 下午 9:55
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -9032370413612144718L;
    /**错误码*/
    private Integer code;

    /**提示信息*/
    private String msg;

    /**具体内容*/
    private T data;

}
