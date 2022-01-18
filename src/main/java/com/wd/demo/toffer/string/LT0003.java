package com.wd.demo.toffer.string;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: wangdi
 * @Date: 2022/1/16 16:17
 */
public class LT0003 {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    private static class Solution {
        public int lengthOfLongestSubstring(String s) {
            // 滑动窗口
            int ans = 0;
            Map<Character, Integer> window = new HashMap<>();
            int l = 0, r = 0, n = s.length();
            while (r < n) {
                char rightChar = s.charAt(r++);
                window.put(rightChar, window.getOrDefault(rightChar, 0) + 1);
                while (window.get(rightChar) > 1) {
                    char leftChar = s.charAt(l++);
                    window.put(leftChar, window.get(leftChar)-1);
                }
                ans = Math.max(ans, r - l);
            }
            return ans;
        }
    }
}
