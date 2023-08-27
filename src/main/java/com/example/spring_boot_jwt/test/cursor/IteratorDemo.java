package com.example.spring_boot_jwt.test.cursor;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class IteratorDemo {
    public static void main(String[] args) {
        //list example
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        Iterator itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "harsh");
        map.put(2, "sindhwani");
        map.put(3, "Arora");

        Iterator<Map.Entry<Integer, String>> iterator1 = map.entrySet().iterator();

        while (iterator1.hasNext()){
            Map.Entry<Integer, String> entry = iterator1.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println("++++++++++");
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            if(entry.getKey()==2){
                map.remove(entry.getKey());
            }
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        System.out.println(map);

    }
}
