package com.renfrew;

public class MakeBricks {
    public static void main(final String[] args) {
        System.out.println(makeBricks(3, 1, 8));
        System.out.println(makeBricks(3, 1, 9));
        System.out.println(makeBricks(3, 2, 10));
    }

    public static boolean makeBricks(int small, int big, int goal) {
        int bigNeeded = goal / 5;

        if (big >= bigNeeded && goal % 5 <= small) {
            return true;
        } else if (big >= bigNeeded) {
            return false;
        }

        if (goal - big * 5 <= small) {
            return true;
        }
        
        return false; 
    }
}