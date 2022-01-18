package com.wd.demo.toffer.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * @Author: wangdi
 * @Date: 2022/1/9 16:56
 */
public class Offer35 {
    public static void main(String[] args) {

    }

    private static class Solution {
        Map<Node, Node> visited = new HashMap<>();

        public Node copyRandomList(Node head) {
            return search(head);
        }

        private Node search(Node node) {
            if (node == null) return null;
            if (visited.containsKey(node)) {
                return visited.get(node);
            }
            Node cur = new Node(node.val);
            visited.put(node, cur);
            cur.next = search(node.next);
            cur.random = search(node.random);
            return cur;
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

