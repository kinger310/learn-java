package com.wd.demo.toffer.dp;

import java.util.Arrays;

/**
 * @Author: wangdi
 * @Date: 2022/1/18 22:24
 */
public class LT0121 {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private static class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[] dp = new int[n+1];
            int[] buy = new int[n+1];
            buy[0] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                buy[i+1] = Math.min(buy[i], prices[i]);
                dp[i+1] = Math.max(prices[i]-buy[i+1], dp[i]);
            }
            // System.out.println(Arrays.toString(dp));
            return dp[n];
        }
    }
}
