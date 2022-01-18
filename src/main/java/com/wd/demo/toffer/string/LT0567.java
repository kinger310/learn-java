package com.wd.demo.toffer.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 22:00
 */
public class LT0567 {
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));

    }

    private static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            if (m > n) return false;
            int[] window = new int[26];
            for (char c: s1.toCharArray()) {
                window[c - 'a'] --;
            }
            int l = 0, r = 0;
            while (r < n) {
                // 右滑
                char rightChar = s2.charAt(r++);
                window[rightChar-'a'] ++;
                while (window[rightChar-'a'] > 0) {
                    char leftChar = s2.charAt(l++);
                    window[leftChar-'a']--;
                }
                if (r - l == m) return true;
            }
            return false;
        }
    }
}
