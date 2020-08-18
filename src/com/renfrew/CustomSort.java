package com.renfrew;

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
