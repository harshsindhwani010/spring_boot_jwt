package com.example.spring_boot_jwt.demo;

import java.util.HashMap;
import java.util.Map;

public class DuplicateRemove {
    public static void main(String[] args) {
        String str = "my name is harsh harsh harsh";
        String[] str2 = str.split(" ");

        Map<String, Integer> map = new HashMap();

        for(int i=0;i<str2.length;i++){
            if(map.containsKey(str2[i])){
                map.put(str2[i], (map.get(str2[i])+1));
            }else{
                map.put(str2[i], 1);
            }
        }
        System.out.println(map);


    }
}
