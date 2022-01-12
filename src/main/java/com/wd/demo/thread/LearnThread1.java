package com.wd.demo.thread;

public class LearnThread1 {
    public static void main(String[] args) {
        Runnable r = () -> {
            System.out.println("new thread");
        };
        Thread t = new Thread(r);
        t.start();

        System.out.println("main");

    }
}
