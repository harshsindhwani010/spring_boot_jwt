package com.example.spring_boot_jwt.demo;

import java.util.*;

public class ListIteratorDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("harsh", 1);
        map.put("sindhwani", 2);
        map.put("arora", 3);

        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        ListIterator<Map.Entry<String, Integer>> iterator = entryList.listIterator();

        while (iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
