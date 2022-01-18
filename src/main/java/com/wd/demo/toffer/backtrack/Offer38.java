package com.wd.demo.toffer.backtrack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 17:06
 */
public class Offer38 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().permutation("abc")));
    }
    private static class Solution {
        Set<String> ans;
        boolean[] visited;
        String base;

        public String[] permutation(String s) {
            ans = new HashSet<>();
            visited = new boolean[s.length()];
            base = s;
            backtrack("");
            // return ans.stream().toArray(String[]::new);
            return ans.toArray(new String[0]);
        }

        private void backtrack(String path) {
            if (path.length() == base.length()) {
                ans.add(path);
                return;
            }
            for (int i = 0; i < base.length(); i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    backtrack(path + base.charAt(i));
                    visited[i] = false;
                }
            }
        }

    }
}
