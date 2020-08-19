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

public class CustomSort {
    public static void main(String[] args) {
        int[] test1 = {};
        int[] test2 = {1};
        int[] test3 = {1, 1};
        int[] test4 = {1, 2};
        int[] test5 = {1, 2, 3};
        int[] test6 = {3, 1, 2};

        System.out.println(Arrays.toString(sort(test1)));
        System.out.println(Arrays.toString(sort(test2)));
        System.out.println(Arrays.toString(sort(test3)));
        System.out.println(Arrays.toString(sort(test4)));
        System.out.println(Arrays.toString(sort(test5)));
        System.out.println(Arrays.toString(sort(test6)));
        System.out.println();
    }

    public static int[] sort(int[] a) {
        if (a.length <= 1)
            return a;

        Arrays.sort(a);

        int numElements = 1;
        for (int i = 0; i < a.length - 1; ++i) {
            if (a[i] != a[i+1])
                ++numElements;
        }

        int[] ret = new int[numElements];
        ret[0] = a[0];
        for (int i = 0, j = 0; j < a.length-1; ++j) {
            if (a[j] != a[j + 1]) {
                ret[++i] = a[j + 1];
            }
        }
        return ret;
    }
}
