package com.wd.demo.base;

/**
 * 静态方法不会被覆写
 */
public class LearnStaticMethod {

    public static void main(String[] args) {
        Person p = new Student();
        p.say();  // i am a person

        Student s = new Student();
        s.say();
    }


    private static class Person {
        public static void say() {
            System.out.println("i am a person");
        }
    }

    private static class Student extends Person {
        public static void say() {
            System.out.println("i am a student");
        }
    }

}
