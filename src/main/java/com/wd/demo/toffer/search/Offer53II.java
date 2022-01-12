package com.wd.demo.toffer.search;

/**
 * @Author: wangdi
 * @Date: 2022/1/12 23:02
 */
public class Offer53II {

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{0,1,2,3,4,5,6,7,9}));
    }

    static class Solution {
        public int missingNumber(int[] A) {
            int lo = 0, hi = A.length;
            while (lo < hi) {
                int mid = (hi-lo)/2+lo;
                if (A[mid] == mid) lo = mid+1;
                else hi = mid;
            }
            return lo;
        }
    }
}
