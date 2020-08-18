package com.renfrew;

import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(final String[] args) {
        System.out.println(wordCount(new String[] {"a", "b", "a", "c", "b"}));
        System.out.println(wordCount(new String[] {"c", "b", "a"}));
        System.out.println(wordCount(new String[] {"c", "c", "c", "c"}));
        System.out.println();
    }

    public static Map<String, Integer> wordCount(final String[] strings) {
        Map<String, Integer> ret = new HashMap<>();

        for (final String string : strings) {
            Integer value = ret.get(string);
            if (value == null)
                ret.put(string, 1);
            else
                ret.replace(string,  value + 1);
        }

        return ret;
    }
}