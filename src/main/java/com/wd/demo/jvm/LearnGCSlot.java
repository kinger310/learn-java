package com.wd.demo.jvm;

/**
 * 局部变量表 槽复用对垃圾收集的影响
 * @Author: wangdi
 * @Date: 2022/1/25 22:57
 */
public class LearnGCSlot {
    public static void main(String[] args) {
        // byte[] placeholder = new byte[64*1024*1024];
        {
            byte[] placeholder = new byte[64*1024*1024];
        }
        int a = 0;
        System.gc();
    }
}
