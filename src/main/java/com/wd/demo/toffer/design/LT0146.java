package com.wd.demo.toffer.design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wangdi
 * @Date: 2022/1/19 22:07
 */
public class LT0146 {
    public static void main(String[] args) {
        // Your LRUCache object will be instantiated and called as such:
        int capacity = 2;
        LRUCache obj = new LRUCache(capacity);
        obj.put(1,1);
        obj.put(2,2);
        int param_1 = obj.get(1);
        obj.put(3,3);
        System.out.println(String.class);
    }

    private static class LRUCache {
        // 使用哈希存储双向链表的结点
        // 双向链表double冗余结点，可以省去检查相邻结点是否存在（也可不设计）
        static class DLinkNode {
            int key;
            int val;
            DLinkNode prev;
            DLinkNode next;

            public DLinkNode() {
            }

            public DLinkNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Map<Integer, DLinkNode> cache = new HashMap<>();
        private DLinkNode head = new DLinkNode();
        private DLinkNode tail = new DLinkNode();
        private int capacity;
        private int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            afterNodeAccess(node);
            return node.val;
        }

        public void put(int key, int value) {
            // 先检查有没有该key
            DLinkNode node = cache.get(key);
            if (node == null) {
                // 没有，生成新结点
                DLinkNode newNode = new DLinkNode(key, value);
                cache.put(key, newNode);
                // add node to last
                addToLast(newNode);
                // 若容量溢出，删除头结点!cache删除相应key！
                if (size + 1 > capacity) {
                    // remove head
                    DLinkNode oldNode = head.next;
                    removeNode(oldNode);
                    cache.remove(oldNode.key);
                }
                size++;
            } else {
                // 有key。则修改为新值，并将该结点move to last
                node.val = value;
                afterNodeAccess(node);
            }
        }

        private void afterNodeAccess(DLinkNode node) {
            // move node to last
            // step1: remove node
            removeNode(node);
            // step2: add to last
            addToLast(node);
        }

        private void removeNode(DLinkNode node) {
            DLinkNode p = node.prev, q = node.next;
            p.next = q;
            q.prev = p;
        }

        private void addToLast(DLinkNode node) {
            DLinkNode t = tail.prev;
            tail.prev = node;
            node.next = tail;
            t.next = node;
            node.prev = t;
        }
    }

    private static class LRUCache2 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache2(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
