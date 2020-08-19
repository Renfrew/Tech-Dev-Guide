
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