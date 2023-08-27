package com.example.spring_boot_jwt.test.cursor;

import java.util.Enumeration;
import java.util.Vector;

//Enum cursor
public class EnumerationDemo {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 10; i++) {
            v.add(i);
        }
        System.out.println(v);

        Enumeration enums = v.elements();

        while (enums.hasMoreElements()) {
            System.out.println(enums.nextElement());
            Integer num = (Integer) enums.nextElement();
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
    }
}
