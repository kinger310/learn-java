package com.wd.demo.toffer.linkedlist;

import com.wd.demo.toffer.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 剑指 Offer 24. 反转链表
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * @Author: wangdi
 * @Date: 2022/1/9 15:48
 */

public class Offer24 {
    public static void main(String[] args) {
        ListNode head = ListNode.makeNode(new int[]{1, 2, 3});
        ListNode result = new Solution().reverseList(head);
        System.out.println(ListNode.traverse(result));

        ListNode head2 = ListNode.makeNode(new int[]{1, 2, 3});
        ListNode result2 = new Solution2().reverseList(head2);
        System.out.println(ListNode.traverse(result2));

        ListNode head3 = ListNode.makeNode(new int[]{1, 2, 3});
        ListNode result3 = new Solution3().reverseList(head3);
        System.out.println(ListNode.traverse(result3));
    }

    // 递归写法
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode p = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return p;
        }
    }

    // 递归写法二
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }

        private ListNode reverse(ListNode cur, ListNode prev) {
            if (cur == null) return prev;
            ListNode tmp = reverse(cur.next, cur);
            cur.next = prev;
            return tmp;
        }
    }

    // 迭代法
    static class Solution3 {
        public ListNode reverseList(ListNode head) {
            ListNode cur = head, prev = null;
            while (cur != null) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }
            return prev;
        }

    }
}
