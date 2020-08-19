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
