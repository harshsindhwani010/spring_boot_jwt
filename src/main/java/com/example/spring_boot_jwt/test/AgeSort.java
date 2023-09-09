package com.example.spring_boot_jwt.test;

import java.util.Comparator;

public class AgeSort implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge()-o2.getAge();
    }
}
