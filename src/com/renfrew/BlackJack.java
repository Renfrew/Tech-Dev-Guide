package com.renfrew;

public class BlackJack {
    private static final int JACK = 21;

    public static void main(final String[] args) {
        System.out.println(blackjack(19, 21));
        System.out.println(blackjack(21, 19));
        System.out.println(blackjack(19, 22));
        System.out.println(blackjack(22, 19));
        System.out.println(blackjack(22, 22));
    }

    public static int blackjack(int a, int b) {
        if (a > b && a <= JACK) {
            return a;
        } else if (a > b && b <= JACK) {
            return b;
        } else if (a < b && b <= JACK) {
            return b;
        } else if (a < b && a <= JACK) {
            return a;
        } else {
            return 0;
        }
    }
}