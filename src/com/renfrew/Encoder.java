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