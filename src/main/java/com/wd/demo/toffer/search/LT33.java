package com.wd.demo.toffer.search;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * @Author: wangdi
 * @Date: 2022/1/13 0:02
 */
public class LT33 {
    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{4,5,6,7,0,1,2}, 0));
    }

    static class Solution {
        public int search(int[] A, int target) {
            int lo = 0, hi = A.length-1;
            while (lo <= hi) {
                int mid = (hi-lo)/2+lo;
                if (target == A[mid]) return mid;
                // 4,5,6,7,0,1,2
                if (A[mid] > A[hi]) {
                    if (A[lo] <= target && target < A[mid]) hi = mid-1;
                    else lo = mid+1;
                } else {
                    // A[mid] <= A[hi]
                    // 6,7,0,1,2,3,4
                    if (A[mid] < target && target <= A[hi]) lo = mid+1;
                    else hi = mid-1;
                }
            }
            return -1;
        }
    }
}
