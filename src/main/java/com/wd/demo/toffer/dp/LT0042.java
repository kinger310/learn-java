package com.wd.demo.toffer.dp;

import java.util.Arrays;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 23:34
 */
public class LT0042 {
    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    static class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] left = new int[n];
            int[] right = new int[n];
            int maxLeft = 0, maxRight = 0;
            for (int i = 0; i < n; i++) {
                maxLeft = Math.max(maxLeft, height[i]);
                left[i] = Math.max(maxLeft-height[i], 0);
            }
            for (int j = n-1; j >= 0; j--) {
                maxRight = Math.max(maxRight, height[j]);
                right[j] = Math.max(maxRight-height[j], 0);
            }
            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));
            int ans = 0;
            for (int k = 0; k < n; k++) {
                ans += Math.min(left[k], right[k]);
            }
            return ans;
        }
    }
}
