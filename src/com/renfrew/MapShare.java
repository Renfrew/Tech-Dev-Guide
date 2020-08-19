package com.renfrew;

/*
 * <Foundations of Programming>
 *
 * Copyright ©2020 Liang Chen
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 *  a copy of this software and associated documentation files (the "Software"),
 *  to deal in the Software without restriction, including without limitation the
 *  rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 *  sell copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 *  INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 *  PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 *  OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 *  SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

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
