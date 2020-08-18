package com.renfrew;

import java.util.HashMap;
import java.util.Map;

public class WordZero {
    public static void main(final String[] args) {
        System.out.println(word0(new String[] {"a", "b", "a", "b"}));
        System.out.println(word0(new String[] {"a", "b", "a", "c", "b"}));
        System.out.println(word0(new String[] {"c", "b", "a"}));
        System.out.println();
    }

    public static Map<String, Integer> word0(final String[] strings) {
        Map<String, Integer> ret = new HashMap<>();

        for (final String string : strings) {
            ret.put(string, 0);
        }

        return ret;
    }
}
