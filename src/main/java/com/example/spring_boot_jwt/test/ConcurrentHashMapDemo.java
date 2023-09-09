package com.example.spring_boot_jwt.test;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        ConcurrentHashMap map = new ConcurrentHashMap();
        map.put(1, "harsh");
        map.put(1, "harsh");
        //map.put(3, null);
        //map.put(4, null);
        //map.put(5, "harsh");
        System.out.println(map);

    }
}
