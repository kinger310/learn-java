package com.wd.demo.toffer.tree;

import com.wd.demo.toffer.utils.TreeNode;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 0:28
 */
public class Offer68II {
    public static void main(String[] args) {
        // System.out.println(new Solution().lowestCommonAncestor());
    }

    private static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root==null || p == root || q == root) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left == null? right: right==null? left: root;
        }
    }
}
