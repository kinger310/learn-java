package com.wd.demo.toffer.twopts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangdi
 * @Date: 2022/1/16 23:42
 */
public class LT0015 {
    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    private static class Solution {
        public List<List<Integer>> threeSum(int[] A) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(A);
            int n = A.length;
            for (int i = 0; i < n - 2; i++) {
                // 需要避免重复
                if (i > 0 && A[i] == A[i - 1]) continue;
                int target = -A[i];
                for (int l = i + 1, r = n - 1; l < r; l++) {
                    // 避免重复
                    if (l > i + 1 && A[l] == A[l - 1]) continue;
                    // 保证右侧指针大于左侧指针
                    while (l < r && A[l] + A[r] > target) r--;
                    // 左右指针相遇，跳出小循环
                    if (l == r) break;
                    if (A[l] + A[r] == target) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(A[i]);
                        tmp.add(A[l]);
                        tmp.add(A[r]);
                        ans.add(tmp);
                    }
                }
            }
            return ans;
        }
    }
}
