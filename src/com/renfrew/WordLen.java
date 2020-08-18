package com.renfrew;

import java.util.HashMap;
import java.util.Map;

public class WordLen {
    public static void main(final String[] args) {
        System.out.println(wordLen(new String[] {"a", "bb", "a", "bb"}));
        System.out.println(wordLen(new String[] {"this", "and", "that", "and"}));
        System.out.println(wordLen(new String[] {"code", "code", "code", "bug"}));
        System.out.println();
    }

    public static Map<String, Integer> wordLen(final String[] strings) {
        Map<String, Integer> ret = new HashMap<>();

        for (final String string : strings) {
            ret.put(string, string.length());
        }

        return ret;
    }
}
