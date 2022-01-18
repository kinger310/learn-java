package com.wd.demo.toffer.string;

/**
 * @Author: wangdi
 * @Date: 2022/1/9 17:45
 */
public class Offer58 {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseLeftWords("abcdefg", 2));
        System.out.println(new Solution2().reverseLeftWords("abcdefg", 2));

    }

    private static class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }

    static class Solution2 {
        public String reverseLeftWords(String s, int n) {
            StringBuilder sb = new StringBuilder();
            int length = s.length();
            for (int i = 0; i < length; i++) {
                sb.append(s.charAt((i+n)% length));
            }
            return sb.toString();
        }
    }
}
