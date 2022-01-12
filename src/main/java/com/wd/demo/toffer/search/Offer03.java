package com.wd.demo.toffer.search;

import java.util.HashSet;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @Author: wangdi
 * @Date: 2022/1/12 22:13
 */
public class Offer03 {
    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
        System.out.println(new Solution2().findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }

    static class Solution {
        public int findRepeatNumber(int[] A) {
            HashSet<Integer> set = new HashSet<>();
            for (int num: A) {
                if (set.contains(num)) {
                    return num;
                } else {
                    set.add(num);
                }
            }
            return -1;
        }
    }

    // 原地交换 2,0,1,2
    static class Solution2 {
        public int findRepeatNumber(int[] A) {
            int i = 0;
            while (i < A.length) {
                if (A[i] == i) {
                    i++;
                    continue;
                }
                // 找到了重复元素
                if (A[A[i]] == A[i]) {
                    return A[i];
                }
                // 交换nums[i]与nums[A[i]]
                int tmp = A[i];
                A[i] = A[tmp];
                A[tmp] = tmp;
            }
            return -1;
        }
    }
}
