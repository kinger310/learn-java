package com.wd.demo.toffer.stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * @Author: wangdi
 * @Date: 2022/1/9 15:19
 */
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();

    }

    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty()) {
            minStack.add(x);
        } else {
            minStack.add(Math.min(minStack.getLast(), x));
        }
    }

    public void pop() {
        stack.pollLast();
        minStack.pollLast();
    }

    public int top() {
        return stack.getLast();
    }

    public int min() {
        return minStack.getLast();
    }
}

public class Offer30 {
    public static void main(String[] args) {
    }
}

