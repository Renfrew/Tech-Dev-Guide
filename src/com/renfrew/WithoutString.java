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

public class WithoutString {

    public static void main(String[] args) {
        System.out.println(withoutString("Hello there", "llo"));
        System.out.println(withoutString("Hello there", "e"));
        System.out.println(withoutString("Hello there", "x"));
        System.out.println(withoutString("This is a FISH", "IS"));
        System.out.println(withoutString("THIS is a FISH", "is"));
        System.out.println(withoutString("THIS is a FISH", "iS"));
        System.out.println(withoutString("abxxxxab", "xx"));
        System.out.println(withoutString("abxxxab", "xx"));
        System.out.println(withoutString("abxxxab", "x"));
        System.out.println(withoutString("xxx", "x"));
        System.out.println(withoutString("xxx", "xx"));
        System.out.println(withoutString("xyzzy", "Y"));
        System.out.println(withoutString("", "x"));
        System.out.println(withoutString("abcabc", "b"));
        System.out.println(withoutString("AA22bb", "2"));
        System.out.println(withoutString("1111", "1"));
        System.out.println(withoutString("1111", "11"));
        System.out.println(withoutString("MkjtMkx", "Mk"));
        System.out.println(withoutString("Hi HoHo", "Ho"));
    }

    public static String withoutString(String base, String remove) {
        int startIdx = 0;
        String retStr = "";

        String baseCap = base.toUpperCase();
        String removeCap = remove.toUpperCase();

        for (int i = 0; i < base.length() - remove.length() + 1; ++i) {
            if (isContains(baseCap.substring(i), removeCap)) {
                retStr += base.substring(startIdx, i);
                startIdx = i + remove.length();
                i = startIdx - 1;
            }
        }
        retStr += base.substring(startIdx);
        return retStr;
    }

    public static boolean isContains(String base, String remove) {
        for (int i = 0; i < remove.length(); ++i) {
            if (base.charAt(i) != remove.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
