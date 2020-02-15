package com.zzmall.util;

import java.math.BigDecimal;

/**
 * Created by zz on 2018/5/13.
 */
public class BigDecimalUtil {

    //使用BigDecimal进行精度计算的时候一定要使用其String构造器
    private BigDecimalUtil(){

    }

   public static BigDecimal add(double v1, double v2){
       BigDecimal b1 = new BigDecimal(Double.toString(v1));
       BigDecimal b2 = new BigDecimal(Double.toString(v2));
       return b1.add(b2);
   }

    public static BigDecimal sub(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2);
    }

    public static BigDecimal mul(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2);
    }

    public static BigDecimal div(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        //除法会出现除不尽的情况，所以要选择一种规则进行保留
        //第二个参数表示保留位数，第三个参数表示保留规则，这里使用四舍五入
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP);
    }

}
