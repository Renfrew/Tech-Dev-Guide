package com.renfrew;

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
