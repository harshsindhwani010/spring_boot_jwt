package com.example.spring_boot_jwt.demo;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IteratorDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "harsh");
        map.put(2, "arora");
        map.put(3, "sindhwani");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        map.entrySet().stream().forEach(entry->{
            System.out.println(entry.getKey()+"::"+entry.getValue());
        });

        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
            //  System.out.println(iterator.next());
        }


    }
}
