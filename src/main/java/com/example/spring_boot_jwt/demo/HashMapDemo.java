package com.example.spring_boot_jwt.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HashMapDemo {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("harsh", 30),
                new Person("kamal", 33)
        );

        Map<String, Integer> map = personList.stream().collect(Collectors.toMap(
                Person::getName,
                Person::getAge
        ));
        System.out.println(map);

        map.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
    }
}
