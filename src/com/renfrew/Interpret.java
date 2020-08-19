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
