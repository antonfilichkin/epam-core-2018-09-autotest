package com.epam.se03;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

public class FormatterTest {

    @Test
    void name() {
//        PrintStream out = System.out;
//        out.printf("%s", "Hello, world");

        boolean b1 = true;
        Boolean b2 = null;
        System.out.println("1. - " + b1 + ", " + b2);
        System.out.printf("2. - %2$b, %1$b%n", b1, b2);
        System.out.printf("3. - %b, %b%n", b1, b2);
        System.out.printf("4. - %b, %b, %b%n", b1, b2, b2);
        System.out.printf("5. - %b, %b, %<b%n", b1, b2);


    }
}
