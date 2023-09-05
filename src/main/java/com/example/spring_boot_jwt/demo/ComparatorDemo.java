package com.example.spring_boot_jwt.demo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class SortByName implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o2.name);
    }
}

class SortBtAge implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}

class SortBySalary implements Comparator<Student>{

    @Override
    public int compare(Student o1, Student o2) {
        return o1.salary-o2.salary;
    }
}

@AllArgsConstructor
@NoArgsConstructor
@ToString
class Student{
    public String name;
    public int age;
    public int salary;
}

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("harsh", 3, 12000));
        list.add(new Student("zebra", 10, 7000));
        list.add(new Student("kamal", 30, 70000));
        list.add(new Student("jayti", 20, 50000));
        System.out.println(list);
        Collections.sort(list, new SortByName());
        System.out.println(list);
        Collections.sort(list, new SortBtAge());
        System.out.println(list);
        Collections.sort(list, new SortBySalary());
        System.out.println(list);
    }
}
