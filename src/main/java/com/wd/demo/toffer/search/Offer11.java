package com.wd.demo.toffer.search;

/**
 * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @Author: wangdi
 * @Date: 2022/1/12 23:18
 */
public class Offer11 {
    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{3,1}));
    }

    static class Solution {
        public int minArray(int[] A) {
            int lo = 0, hi = A.length-1;
            while (lo <= hi) {
                int mid = (hi-lo)/2+lo;
                if (A[mid] > A[hi]) lo = mid + 1;
                else if (A[mid] < A[hi]) hi = mid;
                else hi--;
            }
            return A[lo];
        }
    }
}
