package com.renfrew;

import java.util.Arrays;

public class Interpret {
    public static void main(String[] args) {
        System.out.println(interpret(1, new String[]{"+"}, new int[]{1}));
        System.out.println(interpret(4, new String[]{"-"}, new int[]{2}));
        System.out.println(interpret(1, new String[]{"+", "*"}, new int[]{1, 3}));
        System.out.println();
    }

    public static int interpret(int value, String[] commands, int[] args) {
        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "+":
                    value += args[i];
                    break;
                case "-":
                    value -= args[i];
                    break;
                case "*":
                    value *= args[i];
                    break;
                default:
                    return -1;
            }
        }
        return value;
    }
}
