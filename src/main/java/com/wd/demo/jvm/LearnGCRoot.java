package com.wd.demo.jvm;

/**
 * GCRoots 测试：虚拟机栈（栈帧中的局部变量）中引用的对象作为GCRoots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 * @Author wangdi
 * @Date 2022/1/26 10:27 上午
 */
public class LearnGCRoot {
    //private int _MB = 1024 * 1024;
    private byte[] memo = new byte[80 * 1024*1024];

    public static void main(String[] args) {
        method01();
        System.out.println("返回main方法");
        System.gc();
        System.out.println("第二次GC完成");
    }

    public static void method01() {
        LearnGCRoot t = new LearnGCRoot();
        System.gc();
        System.out.println("第一次GC完成");
    }

}
