package com.wd.demo.toffer.search;

import java.util.Arrays;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * @Author: wangdi
 * @Date: 2022/1/12 22:32
 */
public class Offer53 {

    public static void main(String[] args) {
        System.out.println(new Solution().search(new int[]{5,7,8,8,10}, 8));
    }

    private static class Solution {
        // 5,7,8,8,10
        public int search(int[] nums, int target) {
            int left = binarySearchRight(nums, target-1);
            int right = binarySearchRight(nums, target);
            return right - left;
        }

        private int binarySearchRight(int[] A, int target) {
            int lo = 0, hi = A.length;
            while (lo < hi) {
                int mid = (hi - lo) / 2 + lo;
                if (target < A[mid]) hi = mid;
                else lo = mid+1;
            }
            return lo;
        }

        private int binarySearchLeft(int[] A, int target) {
            Arrays.binarySearch(A, target);
            return 0;
        }
    }
}
