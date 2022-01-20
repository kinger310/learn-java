package com.wd.demo.toffer.dp;

/**
 * @Author: wangdi
 * @Date: 2022/1/20 23:17
 */
public class LT0416 {
    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1,5,11,5}));
    }

    private static class Solution {
        public boolean canPartition(int[] nums) {
            int n = nums.length;
            int total = 0;
            for (int i = 0; i < n; i++) {
                total += nums[i];
            }
            if (total % 2 != 0) return false;
            // 背包总价值  0-1 背包  物品只能用一次
            int W = total / 2;
            // 价值作为dp
            boolean[] dp = new boolean[W+1];
            dp[0] = true;
            for (int i = 0; i < n; i++) {
                for (int j = W; j >= nums[i]; j--) {
                    dp[j] = dp[j-nums[i]] || dp[j];
                }
            }
            return dp[W];
        }
    }
}
