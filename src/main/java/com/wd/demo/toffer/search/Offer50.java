package com.wd.demo.toffer.search;


/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * @Author: wangdi
 * @Date: 2022/1/12 23:57
 */
public class Offer50 {
    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("abaccdeff"));
    }

    static class Solution {
        public char firstUniqChar(String s) {
            int[] arr = new int[26];
            for (char c: s.toCharArray()) arr[c-'a']++;
            for (char c: s.toCharArray()) if (arr[c-'a'] == 1) return c;
            return ' ';
        }
    }
}
