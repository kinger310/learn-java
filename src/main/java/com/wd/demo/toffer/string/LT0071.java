package com.wd.demo.toffer.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 22:55
 */
public class LT0071 {
    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
    }

    static class Solution {
        public String simplifyPath(String path) {
            String[] items = path.split("/");
            Deque<String> stack = new LinkedList<>();
            for (String item:
                    items) {
                if (item.equals("") || item.equals(".")) continue;
                if (item.equals("..")) stack.pollLast();
                else stack.offer(item);
            }
            return "/" + String.join("/", stack);
        }
    }
}
