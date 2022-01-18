package com.wd.demo.toffer.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 16:44
 */
public class LT0014 {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

    private static class Solution {
        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if (n == 0) return "";
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    return s1.length() - s2.length();
                }
            });
            String common = strs[0];
            for (int i = 1; i < n; i++) {
                common = findCommonPrefix(common, strs[i]);
                if (common.equals("")) {
                    return "";
                }
            }
            return common;
        }

        private String findCommonPrefix(String common, String s) {
            int i = 0, j = 0, m = common.length(), n = s.length();
            while (i < m && j < n) {
                if (common.charAt(i) != s.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            return common.substring(0, i);
        }
    }
}
