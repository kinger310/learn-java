package com.wd.demo.toffer.linkedlist;

import com.wd.demo.toffer.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * @Author: wangdi
 * @Date: 2022/1/9 15:48
 */

public class Offer06 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeNode(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(new Solution1().reversePrint(head)));
        ListNode head2 = ListNode.makeNode(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(new Solution2().reversePrint(head2)));
        ListNode head3 = ListNode.makeNode(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(new Solution2().reversePrint(head3)));
    }

    // 翻转链表：遍历写法
    private static class Solution1 {
        public int[] reversePrint(ListNode head) {
            ListNode p = head, prev = null;
            while (p != null) {
                ListNode tmp = p.next;
                p.next = prev;
                prev = p;
                p = tmp;
            }
            ArrayList<Integer> arrayList = new ArrayList<>();
            while (prev != null) {
                arrayList.add(prev.val);
                prev = prev.next;
            }
            return arrayList.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    // 翻转链表:递归写法
    private static class Solution2 {
        ArrayList<Integer> arrayList = new ArrayList<>();

        public int[] reversePrint(ListNode head) {
            reverse(head);
            return arrayList.stream().mapToInt(Integer::valueOf).toArray();
        }

        private void reverse(ListNode head) {
            if (head == null) return;
            reverse(head.next);
            arrayList.add(head.val);
        }
    }

    // 辅助栈
    private static class Solution3 {
        public int[] reversePrint(ListNode head) {
            // 辅助栈
            Deque<Integer> stack = new LinkedList<>();
            while (head != null) {
                stack.add(head.val);
                head = head.next;
            }
            int[] ans = new int[stack.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = stack.removeLast();
            }
            return ans;
        }
    }
}
