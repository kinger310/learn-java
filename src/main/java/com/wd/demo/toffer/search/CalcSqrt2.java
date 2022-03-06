package com.wd.demo.toffer.search;

import java.math.BigDecimal;

/**
 * 已知 sqrt (2)约等于 1.414，要求不用数学库，求 sqrt (2)精确到小数点后 10 位
 * https://www.jianshu.com/p/0cb23d985189
 * @Author: wangdi
 * @Date: 2022/1/22 11:08
 */
public class CalcSqrt2 {
    private static final double E = 1e-10;

    public static void main(String[] args) {
        double lo = 1.41, hi = 1.42;
        while (hi - lo > E) {
            double mid = (lo+hi) /2;
            if (mid*mid > 2) hi = mid;
            else lo = mid;
            // System.out.println(String.format("%f, %f, %f", lo,  hi, delta));
        }
        System.out.println(lo + " " + hi);
        System.out.println(Math.sqrt(2));
    }
}
