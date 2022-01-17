package com.wd.demo.toffer.linkedlist;

import com.wd.demo.toffer.utils.ListNode;

/**
 * @Author: wangdi
 * @Date: 2022/1/18 0:26
 */
public class LT0023 {
    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int lo = 0, hi = lists.length-1;
            return merge(lists, lo, hi);
        }

        private ListNode merge(ListNode[] lists, int lo, int hi) {
            if (lo > hi) return null;
            if (lo == hi) return lists[lo];
            int mid = (lo+hi)/2;
            return mergeTwoLists(merge(lists, lo, mid), merge(lists, mid+1, hi));
        }

        private ListNode mergeTwoLists(ListNode p, ListNode q) {
            if (p == null) return q;
            if (q == null) return p;
            ListNode dummy = new ListNode(0), cur = dummy;
            while (p != null && q != null) {
                if (p.val > q.val) {
                    cur.next = new ListNode(q.val);
                    q = q.next;
                } else {
                    cur.next = new ListNode(p.val);
                    p = p.next;
                }
                cur = cur.next;
            }
            if (p == null) cur.next = q;
            else cur.next = p;
            return dummy.next;
        }
    }
}
