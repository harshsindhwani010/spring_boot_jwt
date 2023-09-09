package com.example.spring_boot_jwt.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        list.add(new Student(1, "harsh", 21));
        list.add(new Student(2, "arora", 90));
        list.add(new Student(3, "kamal", 50));
        list.add(new Student(4, "sindhwani", 40));
        System.out.println(list);
        Collections.sort(list);

        System.out.println(list);
    }
}
