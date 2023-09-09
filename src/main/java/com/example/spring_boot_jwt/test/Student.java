package com.example.spring_boot_jwt.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Comparable<Student>{
    private int id;
    private String name;
    private int age;

    @Override
    public int compareTo(Student o) {
        if(age==o.age) {
            return 0;
        } else if(age>o.age){
            return 1;
        }else{
            return -1;
        }
    }
}
