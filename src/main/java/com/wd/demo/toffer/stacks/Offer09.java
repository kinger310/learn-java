package com.wd.demo.toffer.stacks;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/solution/mian-shi-ti-09-yong-liang-ge-zhan-shi-xian-dui-l-3/
 * @Author: wangdi
 * @Date: 2022/1/9 14:58
 */
public class Offer09 {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        obj.appendTail(1);
        int param_2 = obj.deleteHead();
        System.out.println(param_2);
    }
}

class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.add(stack1.pop());
            }
        }
        return stack2.isEmpty()? -1 : stack2.pop();
    }
}
