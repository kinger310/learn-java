package com.wd.demo.toffer.design;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wangdi
 * @Date 2022/2/9 4:56 下午
 */
public class LT0460 {
    public static void main(String[] args) {

    }

    private static class LFUCache {

        static class Node {
            int key;
            int val;
            int freq = 1;
            Node prev;
            Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            public Node() {
            }
        }

        static class DLinkedList {
            Node head;
            Node tail;

            public DLinkedList() {
                head = new Node();
                tail = new Node();
                head.next = tail;
                tail.prev = head;
            }

            public void removeNode(Node node) {
                Node p = node.prev, q = node.next;
                p.next = q;
                q.prev = p;
            }

            public void addNode(Node node) {
                Node t = head.next;
                t.prev = node;
                node.next = t;
                node.prev = head;
                head.next = node;
            }
        }



        Map<Integer, Node> cache;
        // 存储每个频次对应的双向链表
        Map<Integer, DLinkedList> freqMap;
        int capacity;
        int size;
        int minFreq; // 存储最小频次

        public LFUCache(int capacity) {
            this.capacity = capacity;
            cache = new HashMap<>();
            freqMap = new HashMap<>();
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;
            freqInc(node);
            return node.val;
        }

        public void put(int key, int value) {
            if (capacity == 0) return;
            Node node = cache.get(key);
            if (node != null) {
                node.val = value;
                freqInc(node);
            } else {
                size++;
                if (size > capacity) {
                    size--;
                    // 删除最小频率；如果平局出现，删除最久未使用
                    DLinkedList minFreqLinkedList = freqMap.get(minFreq);
                    Node oldNode = minFreqLinkedList.tail.prev;
                    minFreqLinkedList.removeNode(oldNode);
                    cache.remove(oldNode.key);
                }
                // 生成新节点
                Node newNode = new Node(key, value);
                cache.put(key, newNode);
                DLinkedList dlist = freqMap.get(1);
                if (dlist == null) {
                    dlist = new DLinkedList();
                    freqMap.put(1, dlist);
                }
                dlist.addNode(newNode);
                minFreq = 1;
            }

        }

        private void freqInc(Node node) {
            // 需要将节点从freqMap中删除，新的+1 key里增加
            int freq = node.freq;
            DLinkedList dlist = freqMap.get(freq);
            dlist.removeNode(node);
            // 若此节点频率等于最小频率，且删除后链表空了，最小值频率需要加一。
            if (dlist.head.next == dlist.tail && minFreq == freq) {
                minFreq = freq + 1;
            }
            node.freq++;
            dlist = freqMap.get(freq+1);
            if (dlist == null) {
                dlist = new DLinkedList();
                freqMap.put(freq+1, dlist);
            }
            dlist.addNode(node);

        }


    }
}
