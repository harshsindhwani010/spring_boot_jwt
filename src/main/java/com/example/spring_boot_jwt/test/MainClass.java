package com.example.spring_boot_jwt.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Student> list = new ArrayList();
        list.add(new Student(1, "harsh", 21));
        list.add(new Student(2, "arora", 90));
        list.add(new Student(3, "kamal", 50));
        list.add(new Student(4, "sindhwani", 40));
      //  System.out.println(list);
        Collections.sort(list, new AgeSort());
        System.out.println(list);
        Collections.sort(list, new NameSort());
        System.out.println(list);

        Iterator itr = list.iterator();
        while (itr.hasNext()){
            Student student = (Student) itr.next();
            System.out.println(student.getName()+" "+student.getAge());
        }
    }
}
