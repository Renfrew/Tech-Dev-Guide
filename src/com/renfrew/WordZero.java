package com.renfrew;


public class WordZero {
    public static void main(String[] args) {
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
