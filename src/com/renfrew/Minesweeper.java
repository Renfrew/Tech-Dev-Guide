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

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Minesweeper {
    private static final int DEFAULT_EASY_ROW = 9;
    private static final int DEFAULT_EASY_COL = 9;
    private static final int DEFAULT_EASY_MINE = 10;
    
    private static final int DEFAULT_MEDIUM_ROW = 16;
    private static final int DEFAULT_MEDIUM_COL = 16;
    private static final int DEFAULT_MEDIUM_MINE = 40;
    
    private static final int DEFAULT_EXPERT_ROW = 30;
    private static final int DEFAULT_EXPERT_COL = 16;
    private static final int DEFAULT_EXPERT_MINE = 99;

    private int customRow;
    private int customCol;
    private int customMine;

    enum DIFFICULTY {
        EASY,
        MEDIUM,
        EXPERT,
        CUSTOM,
    }

    private static final int CELL_MINE = 9;
    enum CellStatus {
        HIDDEN,
        SHOW,
        FLAGED,
    }

    int steps; // Steps that the player have taken.
    Date date; // Time that the player start the game
    Matrix board; // Game board
    boolean gameEnd; // Indicate if a initiallize is required
    int numberMine; // Mines left on the matrix
    int numberHidden; // Number of cells that are hidden and not flaged
    DIFFICULTY level; // Determine the size of the game board

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.initGame(DIFFICULTY.EASY);
        game.startGame();
    }

    void startGame() {
        System.out.println("Welcome to the Mine Sweeper by Liang Chen");
        System.out.println("This game has " + board.rows() + " rows and " + board.cols() + " columns");
        System.out.println("A comand will be a character followed by a row and a column number");
        System.out.println("The character can be either r or l, which means flag or left click");
        System.out.println("Ex: 'r 5 3' means put flag on row 5 column 3");
        System.out.println("Let's start");
        
        Scanner sc = new Scanner(System.in);
        while (true) {
            board.printMatrix();
            System.out.println();
            System.out.println("Please input a command");

            char command = sc.next().charAt(0);
            int row = sc.nextInt();
            int col = sc.nextInt();

            System.out.println();
            onClick(command, row, col);
            System.out.println();

            if (gameEnd) break;
        }
        sc.close();
    }

    void onClick(char command, int row, int col) {
        Cell cell = board.at(row - 1, col - 1);

        // Right click on a valid position
        if (command == 'r' && cell != null) {
            if (cell.status == CellStatus.FLAGED) {
                ++numberMine;
                ++numberHidden;
                cell.status = CellStatus.HIDDEN;
            } else if (cell.status == CellStatus.HIDDEN) {
                --numberMine;
                --numberHidden;
                cell.status = CellStatus.FLAGED;
            }
        }

        // Left click on a valid postion
        if (command == 'l' && cell != null) {
            if (cell.value  == CELL_MINE) {
                gameEnd("You lost.");
            } else if (cell.value == 0) {
                showSurrounding(row - 1, col - 1);
                if (numberHidden == 0) {
                    gameEnd("You win.");
                }
            } else if (cell.status == CellStatus.HIDDEN) {
                cell.status = CellStatus.SHOW;
                --numberHidden;

                if (numberHidden == 0) {
                    gameEnd("You win.");
                }
            }
        }
    }

    void gameEnd(String result) {
        gameEnd = true;

        for (int row = 0; row < board.rows(); row++) {
            for (int col = 0; col < board.cols(); col++) {
                Cell cell = board.at(row, col);
                cell.status = CellStatus.SHOW;
            }
        }

        board.printMatrix();
        System.out.println(result);
    }

    void showSurrounding(int row, int col) {
        Cell cell = board.at(row, col);
        if (cell != null && cell.status == CellStatus.HIDDEN) {
            --numberHidden;
            cell.status = CellStatus.SHOW;

            if (cell.value == 0) {
                showSurrounding(row - 1, col - 1);
                showSurrounding(row - 1, col);
                showSurrounding(row - 1, col + 1);
                showSurrounding(row, col - 1);
                showSurrounding(row, col + 1);
                showSurrounding(row + 1, col - 1);
                showSurrounding(row + 1, col);
                showSurrounding(row + 1, col + 1);
            }
        }
    }

    void initGame(DIFFICULTY newLevel) {
        switch (newLevel) {
            case EASY:
                numberMine = DEFAULT_EASY_MINE;
                board = new Matrix(DEFAULT_EASY_ROW, DEFAULT_EASY_COL);
                break;
            case MEDIUM:
                numberMine = DEFAULT_MEDIUM_MINE;
                board = new Matrix(DEFAULT_MEDIUM_ROW, DEFAULT_MEDIUM_COL);
                break;
            case EXPERT:
                numberMine = DEFAULT_EXPERT_MINE;
                board = new Matrix(DEFAULT_EXPERT_ROW, DEFAULT_EXPERT_COL);
                break;
            default:
                numberMine = customMine;
                board = new Matrix(customRow, customCol);
                break;
        }

        steps = 0;
        date = new Date();
        level = newLevel;
        gameEnd = false;
        numberHidden = board.rows() * board.cols();
        generateMines(numberMine);
    }

    void generateMines(int numMines) {
        final int numbereCells = board.rows() * board.cols();
        Random rand = new Random();

        while (numMines != 0) {
            int position = rand.nextInt(numbereCells);
            int row = position / board.cols();
            int col = position % board.cols();
            Cell cell = board.at(row, col);

            if (cell != null && cell.value != CELL_MINE ) {
                cell.value = CELL_MINE;
                board.addOne(row - 1, col - 1);
                board.addOne(row - 1, col);
                board.addOne(row - 1, col + 1);
                board.addOne(row, col - 1);
                board.addOne(row, col + 1);
                board.addOne(row + 1, col - 1);
                board.addOne(row + 1, col);
                board.addOne(row + 1, col + 1);

                --numMines;
            }
        }
    }
    
    class Matrix {
        private int rowNumber;
        private int colNumber;

        private Cell[][] matrix;

        Matrix(int rows, int cols) {
            rowNumber = rows;
            colNumber  =cols;
            init();
        }

        void init() {
            matrix = new Cell[rowNumber][colNumber];
            for (Cell[] row : matrix) {
                for (int col = 0; col < row.length; ++col) {
                    row[col] = new Cell();
                }
            }
        }

        void resize(int rows, int cols) {
            rowNumber = rows;
            colNumber = cols;
            init();
        }

        Cell at(int row, int col) {
            if (0 <= row && row < rowNumber && 0 <= col && col < colNumber) {
                return matrix[row][col];
            } else {
                return null;
            }
        }

        void set(int row, int col, Cell value) {
            if (0 <= row && row < rowNumber && 0 <= col && col < colNumber) {
                matrix[row][col] = value;
            }
        }

        // If the cell is valid and is not a mine, 
        // then the value in the cell will be added one
        void addOne(int row, int col) {
            if (0 <= row && row < rowNumber
             && 0 <= col && col < colNumber
             && matrix[row][col].value != CELL_MINE) {

                matrix[row][col].value += 1;
            }
        }

        int rows() {
            return rowNumber;
        }

        int cols() {
            return colNumber;
        }

        void printMatrix() {
            for (Cell[] row : matrix) {
                for (Cell i : row) {
                    switch (i.status) {
                        case HIDDEN:
                            System.out.print('-');
                            break;
                        case SHOW:
                            if (i.value == 0) {
                                System.out.print(" ");
                            } else if (i.value == CELL_MINE) {
                                System.out.print("*");
                            } else {
                                System.out.print(i.value);
                            }
                            break;
                        case FLAGED:
                            System.out.print('F');
                    }
                    System.out.print(' ');
                }

                System.out.println();
            }
        }
    }

    class Cell {
        int value = 0;
        CellStatus status = CellStatus.HIDDEN;
    }
}