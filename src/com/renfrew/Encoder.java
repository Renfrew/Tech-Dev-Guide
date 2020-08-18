package com.renfrew;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Encoder {
    public static void main(final String[] args) {
        System.out.println(Arrays.toString(encoder(new String[] {"a"}, new String[] {"1", "2", "3", "4"})));
        System.out.println(Arrays.toString(encoder(new String[] {"a", "b"}, new String[] {"1", "2", "3", "4"})));
        System.out.println(Arrays.toString(encoder(new String[] {"a", "b", "a"}, new String[] {"1", "2", "3", "4"})));
        System.out.println();
    }

    public static String[] encoder(final String[] raw, String[] code_words) {
        String[] ret = new String[raw.length];
        Map<String, String> dictionary = new HashMap<>();
        int codeIdx = 0;
        for (int i = 0; i < raw.length; ++i) {
            String value = dictionary.get(raw[i]);
            if (value == null) {
                ret[i] = code_words[codeIdx];
                dictionary.put(raw[i], code_words[codeIdx++]);
            } else {
                ret[i] = value;
            }
        }

        return ret;
    }
}