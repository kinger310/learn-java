package com.wd.demo.base;

/**
 * @Author: wangdi
 * @Date: 2022/1/21 1:00
 */
public class LearnJavaCallByValue {
    private static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        // 省略构造函数、Getter&Setter方法
    }

    public static void main(String[] args) {
        Person taki = new Person("泷");
        Person mitsuha = new Person("三叶");
        wrongSwap(taki, mitsuha);
        System.out.println("taki:" + taki.getName());
        System.out.println("mitsuha:" + mitsuha.getName());
        taki = rightSwap(mitsuha, mitsuha = taki);  //usage: y = swap(x, x=y);
        System.out.println("------------------");
        System.out.println("taki:" + taki.getName());
        System.out.println("mitsuha:" + mitsuha.getName());
    }

    public static void wrongSwap(Person person1, Person person2) {
        Person temp = person1;
        person1 = person2;
        person2 = temp;
        System.out.println("person1:" + person1.getName());
        System.out.println("person2:" + person2.getName());
    }

    public static Person rightSwap(Person p1, Person p2) {
        return p1;
    }

}
