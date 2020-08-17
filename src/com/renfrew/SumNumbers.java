package com.renfrew;

public class SumNumbers {
    public static void main(String[] args) {
        System.out.println(sumNumbers("abc123xyz"));
        System.out.println(sumNumbers("aa11b33"));
        System.out.println(sumNumbers("7 11"));
        System.out.println(sumNumbers("Chocolate"));
        System.out.println(sumNumbers("5hoco1a1e"));
        System.out.println(sumNumbers("5$$1;;1!!"));
        System.out.println(sumNumbers("a1234bb11"));
        System.out.println(sumNumbers(""));
        System.out.println(sumNumbers("a22bbb3"));
        System.out.println();
        System.out.println();
    }

    public static int sumNumbers(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); ++i) {
            int endIdx = isNumber(str, i);
            if (endIdx > i) {
                sum += Integer.parseInt(str.substring(i, endIdx));
                i = endIdx -1;
            }
        }

        return sum;
    }

    public static int isNumber(String str, int startIdx) {
        int endIdx = startIdx;
        while (Character.isDigit(str.charAt(endIdx))) {
            ++endIdx;
            if (endIdx == str.length())
                break;
        }

        return endIdx;
    }
}
