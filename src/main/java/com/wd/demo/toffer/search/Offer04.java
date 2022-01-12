package com.wd.demo.toffer.search;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @Author: wangdi
 * @Date: 2022/1/12 23:04
 */
public class Offer04 {

    public static void main(String[] args) {
        System.out.println(new Solution().findNumberIn2DArray(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 4));
    }


    static class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            int m = matrix.length;
            if (m <= 0) return false;
            int n = matrix[0].length;
            int i = m-1, j = 0;
            while (i >= 0 && j < n) {
                if (matrix[i][j] > target) i--;
                else if (matrix[i][j] < target) j++;
                else return true;
            }
            return false;
        }
    }
}
