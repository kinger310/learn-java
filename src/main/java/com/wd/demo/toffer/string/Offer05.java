package com.wd.demo.toffer.string;

/**
 * 剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * @Author: wangdi
 * @Date: 2022/1/9 17:29
 */
public class Offer05 {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceSpace("we are haapy"));
    }

    static class Solution {
        public String replaceSpace(String s) {
            int length = s.length();
            char[] array = new char[length * 3];
            int j = 0;
            for (int i = 0; i < length; i++) {
                char c = s.charAt(i);
                if (c == ' ') {
                    array[j++] = '%';
                    array[j++] = '2';
                    array[j++] = '0';
                } else {
                    array[j++] = c;
                }
            }
            return new String(array, 0, j);
        }
    }
}
