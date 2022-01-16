package com.wd.demo.toffer.tree;

import com.wd.demo.toffer.utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: wangdi
 * @Date: 2022/1/17 0:37
 */
public class LT0102 {
    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int n = q.size();
                for (int i = 0; i < n; i++) {
                    TreeNode cur = q.poll();
                    if (cur != null) {
                        tmp.add(cur.val);
                        if (cur.left != null) q.add(cur.left);
                        if (cur.right != null) q.add(cur.right);
                    }
                }
                if (tmp.size() > 0) ans.add(tmp);
            }
            return ans;
        }
    }
}
