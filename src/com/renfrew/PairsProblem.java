
package com.renfrew;

import java.util.HashMap;
import java.util.Map;

public class PairsProblem {
    public static void main(final String[] args) {
        System.out.println(pairs(new String[] {"code", "bug"}));
        System.out.println(pairs(new String[] {"man", "moon", "main"}));
        System.out.println(pairs(new String[] {"man", "moon", "good", "night"}));
        System.out.println();
    }

    public static Map<String, String> pairs(final String[] strings) {
        Map<String, String> ret = new HashMap<>();

        for (final String string : strings) {
            ret.put(string.substring(0, 1), string.substring(string.length() - 1));
        }

        return ret;
    }
}