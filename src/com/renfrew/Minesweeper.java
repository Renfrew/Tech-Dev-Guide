package com.renfrew;

import java.util.Date;
import java.util.Random;

public class Minesweeper {
    private static final int DEFAULT_EASY_ROW = 9;
    private static final int DEFAULT_EASY_COL = 9;
    private static final int DEFAULT_EASY_MINE = 10;

    enum DIFFICULTY {
        EASY,
        MEDIUM,
        EXPERT,
        CUSTOM,
    }

    private static final int CELL_ERROR = -1;
    private static final int CELL_MINE = 9;
    enum CellStatus {
        HIDDEN,
        SHOW,
        FLAGED,
    }

    int steps; // Steps that the player have taken.
    Date date; // Time that the player start the game
    Matrix board; // Game board
    int mineNumber; // Mines left on the matrix
    DIFFICULTY level; // Determine the size of the game board

    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.initGame(DIFFICULTY.EASY);
        game.board.printMatrix();
    }

    void initGame(DIFFICULTY newLevel) {
        switch (newLevel) {
            case EASY:
                mineNumber = DEFAULT_EASY_MINE;
                board = new Matrix(DEFAULT_EASY_ROW, DEFAULT_EASY_COL);
                break;
            case MEDIUM:
                mineNumber = DEFAULT_EASY_MINE;
                board = new Matrix(DEFAULT_EASY_ROW, DEFAULT_EASY_COL);
                break;
            case EXPERT:
                mineNumber = DEFAULT_EASY_MINE;
                board = new Matrix(DEFAULT_EASY_ROW, DEFAULT_EASY_COL);
                break;
            default:
                mineNumber = DEFAULT_EASY_MINE;
                board = new Matrix(DEFAULT_EASY_ROW, DEFAULT_EASY_COL);
                break;
        }

        steps = 0;
        date = new Date();
        level = newLevel;
        generateMines(mineNumber);
    }

    void generateMines(int numMines) {
        final int numbereCells = board.rows() * board.colls();
        Random rand = new Random();

        while (numMines != 0) {
            int position = rand.nextInt(numbereCells);
            int row = position / board.colls();
            int col = position % board.colls();
            int value = board.at(row, col);

            if (value != CELL_ERROR && value != CELL_MINE ) {
                board.set(row, col, CELL_MINE);
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

        int at(int row, int col) {
            if (0 <= row && row < rowNumber && 0 <= col && col < colNumber) {
                return matrix[row][col].value;
            } else {
                return CELL_ERROR;
            }
        }

        void set(int row, int col, int value) {
            if (0 <= row && row < rowNumber && 0 <= col && col < colNumber) {
                matrix[row][col].value = value;
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

        int colls() {
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
                            } else {
                                System.out.print(i.value);
                            }
                            break;
                        case FLAGED:
                            System.out.print('*');
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