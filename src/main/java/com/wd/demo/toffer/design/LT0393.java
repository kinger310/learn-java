package com.wd.demo.toffer.design;

/**
 * @Author: wangdi
 * @Date: 2022/1/20 23:10
 */
public class LT0393 {
    public static void main(String[] args) {
        String aa = "abccccccccc"; // 放在常量池中
        String bb = "abccccccccc"; // 从常量池中查找
        System.out.println(aa == bb);// true
        System.out.println("ab".hashCode());
    }

    private static class Solution {
        public boolean validUtf8(int[] data) {
            return false;
        }
    }


}
