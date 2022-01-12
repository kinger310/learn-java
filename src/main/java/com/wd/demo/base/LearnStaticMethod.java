package com.wd.demo.base;

class Person {
    public static void say() {
        System.out.println("i am a person");
    }
}

class Student extends Person {
    public static void say() {
        System.out.println("i am a student");
    }
}

public class LearnStaticMethod {

    public static void main(String[] args) {
        Person p = new Student();
        p.say();

        Student s = new Student();
        s.say();
    }
}
