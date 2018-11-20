package com.epam.se06.sets;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class SetTest {

    @Test
    void name() {
        Set<Object> set = new HashSet<>(32, 2);
        set.add(set);
        System.out.println(set.contains(set));
    }
}
