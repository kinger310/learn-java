package com.wd.demo.toffer.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 23:09
 */
public class LT0093 {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
    private static class Solution {
        List<String> ans;
        int length;

        public List<String> restoreIpAddresses(String s) {
            ans = new LinkedList<>();
            length = s.length();
            backtrack(s, new LinkedList<>(), 0);
            return ans;
        }

        private void backtrack(String s, LinkedList<String> path, int idx) {
            if (path.size() > 4 || idx > length) return;
            if (path.size() == 4 && idx == length) {
                ans.add(String.join(".", path));
                return;
            }
            for (int j = 1; j < 4; j++) {
                String bloc = s.substring(idx, Math.min(idx+j, length));
                if (isValid(bloc)) {
                    path.offer(bloc);
                    backtrack(s, path, idx+j);
                    path.pollLast();
                }
            }
        }

        private boolean isValid(String bloc) {
            int n = bloc.length();
            if (n == 0) return false;
            int num = Integer.parseInt(bloc);
            if (n == 1) return true;
            if (n == 2 && 10 <= num && num <= 99) return true;
            if (n == 3 && 100 <= num && num <= 255) return true;
            return false;
        }

    }
}
