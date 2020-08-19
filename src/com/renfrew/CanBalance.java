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

public class CanBalance {
    public static void main(String[] args) {
        int[] test1 = {10, 0, 1, -1, 10};
        int[] test2 = {2, 1, 1, 2, 1};
        int[] test3 = {10, 10};
        System.out.println(canBalance(test1));
        System.out.println(canBalance(test2));
        System.out.println(canBalance(test3));
        System.out.println();
        System.out.println();
    }

    public static boolean canBalance(int[] nums) {
        int idxLeft = 0;
        int sumLeft = 0;
        int idxRight = nums.length -1;
        int sumRight = 0;
        boolean isExistNegative = false;

        while (idxLeft <= idxRight) {
            if (sumLeft <= sumRight) {
                if (nums[idxLeft] < 0) {
                    isExistNegative = true;
                }
                sumLeft += nums[idxLeft++];
            } else {
                if (nums[idxRight] < 0) {
                    isExistNegative = true;
                }
                sumRight += nums[idxRight--];
            }
        }

        if (sumLeft != sumRight && isExistNegative) {
            idxLeft = 0;
            sumLeft = 0;
            idxRight = nums.length -1;
            sumRight = 0;

            while (idxLeft <= idxRight) {
                if (sumLeft < sumRight) {
                    sumLeft += nums[idxLeft++];
                } else {
                    sumRight += nums[idxRight--];
                }
            }
        }

        if (sumLeft == sumRight) {
            return true;
        } else {
            return false;
        }
    }
}
