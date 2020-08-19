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
