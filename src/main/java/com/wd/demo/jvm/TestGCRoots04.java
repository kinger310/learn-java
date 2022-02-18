package com.wd.demo.jvm;

/**
 * 测试成员变量引用对象是否可作为GCRoots
 * -Xms1024m -Xmx1024m -Xmn512m -XX:+PrintGCDetails
 *
 * @author wangd
 */
public class TestGCRoots04 {
    private static int _10MB = 10 * 1024 * 1024;
    private TestGCRoots04 t;
    private byte[] memory;

    public TestGCRoots04(int size) {
        memory = new byte[size];
    }

    public static void main(String[] args) {
        TestGCRoots04 t4 = new TestGCRoots04(4 * _10MB);
        t4.t = new TestGCRoots04(8 * _10MB);
        t4 = null;
        // t4之前引用的对象会被回收， 回收40M Minor GC  [PSYoungGen: 44892K->579K(76288K)]
        // t会被一起回收 ， 回收80M。Full GC  [ParOldGen: 81928K->451K(175104K)]
        System.gc();


    }
}
