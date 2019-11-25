package com.chenze.sell.utils;

import com.chenze.sell.VO.ResultVO;
import javafx.beans.binding.ObjectExpression;

/**
 * Create by cz
 * Date： 2019/5/9 0009 下午 11:53
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
