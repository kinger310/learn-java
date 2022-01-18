package com.wd.demo.toffer.string;

import java.util.Arrays;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 22:27
 */
public class LT0043 {
    public static void main(String[] args) {
        System.out.println(new Solution().multiply("123", "456"));
    }

    private static class Solution {
        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            int m = num1.length(), n = num2.length();
            int[] arr = new int[m+n];
            for (int i = m-1; i >= 0; i--) {
                int x = num1.charAt(i)-'0';
                for (int j = n-1; j >= 0; j--) {
                    int y = num2.charAt(j)-'0';
                    arr[i+j+1] += x * y;
                }
            }
            for (int i = m+n-1; i > 0; i--) {
                arr[i-1] += arr[i] / 10;
                arr[i] %= 10;
            }
            //System.out.println(Arrays.toString(arr));
            StringBuilder ans = new StringBuilder();
            for (int i = arr[0]==0?1:0; i < m+n; i++) {
                ans.append(arr[i]);
            }
            return ans.toString();
        }
    }
}
