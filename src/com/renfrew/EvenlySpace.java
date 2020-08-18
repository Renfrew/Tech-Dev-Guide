package com.renfrew;

public class EvenlySpace {
    public static void main(final String[] args) {
        System.out.println(evenlySpaced(2, 4, 6));
        System.out.println(evenlySpaced(4, 6, 2));
        System.out.println(evenlySpaced(4, 6, 3));
    }

    public static boolean evenlySpaced(int a, int b, int c) {
        // a > b > c
        if (a > b && b > c) {
            return a - b == b - c;
        // a > c > b
        } else if (a > b && a > c) {
            return a - c == c - b;
        // c > a > b
        } else if (a > b) {
            return c - a == a - b;
        // c > b > a
        } else if (c > b) {
            return c - b == b - a;
        // b > c > a
        } else if (c > a) {
            return b - c == c - a;
        // b > a > c
        } else {
            return b - a == a - c;
        }
    }
}