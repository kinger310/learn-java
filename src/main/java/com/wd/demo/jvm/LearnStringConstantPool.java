package com.wd.demo.jvm;

/**
 * 运行时常量池的再深入，从jvm的内存分配角度谈谈这道字符串常量池的面试题
 * https://blog.csdn.net/qq_41813208/article/details/111149030
 * @Author: wangdi
 * @Date: 2022/1/21 0:27
 */
public class LearnStringConstantPool {
    public static void main(String[] args) {
        // java 字符串在常量在常量池中已有(sun.misc.Version)，
        // str1 会在Eden区中创建一个新的"java"字符串对象
        String str1 = new StringBuilder("ja").append("va").toString();
        String str2 = str1.intern();
        System.out.println(str1 == str2);// 结果是false（地址不一样）

        System.out.println(System.identityHashCode(str1));
        System.out.println(System.identityHashCode("java"));
        System.out.println(System.identityHashCode(str2));

        String str3 = new StringBuilder("hello").append("world").toString();
        String str4 = str3.intern();
        System.out.println(str3 == str4);// 结果是true

        System.out.println(System.identityHashCode(str3));
        System.out.println(System.identityHashCode(str4));

        // 从字符串常量池中拿对象
        String str44 = "abcd";
        // 直接在堆内存空间创建一个新的对象。
        String str5 = new String("abcd");
        // intern的作用，如果字符串常量池已经包含一个equals的字符串，则直接返回常量池中的引用。
        String str6 = new String("abcd").intern();
        System.out.println(System.identityHashCode(str44));
        System.out.println(System.identityHashCode(str5));
        System.out.println(System.identityHashCode(str6));

    }
}
