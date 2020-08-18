package com.renfrew;

import java.util.HashMap;
import java.util.Map;

public class MapShare {
    public static void main(String[] args) {
        Map<String, String> test1 = new HashMap<>();
        test1.put("a", "aaa");
        test1.put("b", "bbb");
        test1.put("c", "ccc");

        Map<String, String> test2 = new HashMap<>();
        test2.put("b", "xyz");
        test2.put("c", "ccc");

        Map<String, String> test3 = new HashMap<>();
        test3.put("a", "aaa");
        test3.put("c", "ccc");
        test3.put("d", "hi");

        System.out.println(mapShare(test1));
        System.out.println(mapShare(test2));
        System.out.println(mapShare(test3));
    }

    public static Map<String, String> mapShare(Map<String, String> map) {
        String value = map.get("a");
        if (value != null) {
            if (map.containsKey("b"))
                map.replace("b", value);
            else
                map.put("b", value);
        }

        map.remove("c");
        return map;
    }
}
