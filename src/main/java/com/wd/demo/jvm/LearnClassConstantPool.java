package com.wd.demo.jvm;

/**
 * @Author wangdi
 * @Date 2022/2/9 10:14 上午
 */
public class LearnClassConstantPool {
    private final static int A = 1;
    private final static String S = "abc";

    public static void main(String[] args) {
        System.out.println(A);
        System.out.println(S);
    }

    public void say() {
        System.out.println("hello");
    }
}
