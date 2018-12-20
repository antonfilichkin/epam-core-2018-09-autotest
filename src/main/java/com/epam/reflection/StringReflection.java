package com.epam.reflection;

import java.lang.reflect.Field;

public class StringReflection {

    public static void main(String[] args) throws Exception {
        String str = "Java";
        String str2 = "Avaj";

        System.out.println("1. " + str);
        System.out.print("2. ");
        System.out.println("Java");

        System.out.println();
        changeValueProperty(str);

        System.out.println("3. " + str);
        System.out.print("4. ");
        System.out.println("Java");
    }

    private static void changeValueProperty(String s) throws Exception {
        Field field = s.getClass().getDeclaredField("value");
        field.setAccessible(true);
        field.set(s, "Not java".toCharArray());
    }

}
