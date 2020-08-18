package com.renfrew;

import acm.graphics.GCanvas;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private static final String DICTIONARY = "out\\production\\Learning Java\\com\\renfrew\\dictionary.txt";
    private static final char DEFAULT_CHAR = '-';

    private ArrayList<String> dictionary = new ArrayList<>();
    private String word = "";
    private int guessLeft = 8;

    private HangmanCanvas canvas;

    public static void main(String[] args) {
        Hangman game = new Hangman();
        //game.init();
        game.run();
    }

    public void init() {
        canvas = new HangmanCanvas();
        JFrame frame = new JFrame("Hangman");
        frame.setSize(600, 400);
        //frame.getContentPane().add(canvas, BorderLayout.CENTER);
        //GRect square = new GRect(100, 100, 200, 200);
        //square.setFilled(true);
        //square.setFillColor(Color.RED);
        //canvas.add(square);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void run() {
        Hangman game = new Hangman();
        game.readWordsFromFile();

        try {
            game.generateWord();
            game.startHangmanConsole();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readWordsFromFile() {
        dictionary.clear();
        try {
            BufferedReader reader=new BufferedReader(new FileReader(DICTIONARY));

            String line;
            while((line = reader.readLine()) != null)
            {
                dictionary.add(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateWord() throws Exception {
        if (dictionary.size() == 0)
            throw new Exception("Please feed a dictionary txt file.");

        Random rand = new Random();
        word = dictionary.get(rand.nextInt(dictionary.size()));
        word = word.toUpperCase();
    }

    private void startHangmanConsole() {
        System.out.println("Welcome to Hangman!");

        char[] currentWord = new char[word.length()];
        for (int i = 0; i < word.length(); ++i) {
            currentWord[i] = DEFAULT_CHAR;
        }

        guessLeft = 8;
        while (true) {
            System.out.println("The word now looks like this: " + new String(currentWord));
            if (guessLeft > 1) {
                System.out.println("You have " + guessLeft + " guesses left.");
            } else {
                System.out.println("You have only one guess left.");
            }

            Scanner reader = new Scanner(System.in);
            char c;
            while (true) {
                String input = reader.next();
                if (input.length() == 1) {
                    c = input.charAt(0);
                    break;
                }

                System.out.println("Please input only one character");
            }

            System.out.println("Your guess: " + Character.toUpperCase(c));
            currentWord = isGuessed(currentWord, c);

            reader.close();
            if(isWin(currentWord)) {
                System.out.println("You guessed the word: " + word);
                System.out.println("You win.");
                return;
            }

            if (guessLeft == 0) {
                System.out.println("You're completely hung.");
                System.out.println("The word was: " + word);
                System.out.println("You lose.");
                return;
            }
        }
    }

    private char[] isGuessed(char[] currentWord, char guessChar) {
        guessChar = Character.toUpperCase(guessChar);
        boolean isGuessed = false;
        for (int i = 0; i < currentWord.length; ++i) {
            if (guessChar == word.charAt(i)) {
                isGuessed = true;
                currentWord[i] = guessChar;
            }
        }

        if (isGuessed) {
            System.out.println("That guess is correct.");
        } else {
            --guessLeft;
            System.out.println("There are no " + guessChar + "'s in the word.");
        }

        return currentWord;
    }

    private boolean isWin(char[] currentWord) {
        for (char c: currentWord) {
            if (c == DEFAULT_CHAR)
                return false;
        }
        return true;
    }
}
