package com.wd.demo.toffer.tree;

import com.wd.demo.toffer.utils.TreeNode;

import java.util.*;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 0:37
 */
public class LT0102 {
    public static void main(String[] args) {

    }

    private static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while (!q.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    TreeNode cur = q.poll();
                    if (cur != null) {
                        tmp.add(cur.val);
                        if (cur.left != null) q.offer(cur.left);
                        if (cur.right != null) q.offer(cur.right);
                    }
                }
                if (tmp.size() > 0) ans.add(tmp);
            }
            return ans;
        }
    }
}
