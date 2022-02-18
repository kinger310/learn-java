package com.wd.demo.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wangdi
 * @Date 2022/1/24 3:09 下午
 */
public class LearnGeneric {
    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<>();

        list.add(12);
        // 1.编译期间直接添加会报错
        // list.add("a");
            Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        // 2.运行期间通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);


    }

}
