package com.sudoku.solver.logic;

import com.sudoku.solver.exception.SudokuException;

public class SudokuSolver {

    private static final String SUDOKU_SOLVED = "Sudoku zostało rozwiązane";
    private final int[][] sudokuTable;

    public SudokuSolver(int[][] sudokuTable) {
        this.sudokuTable = sudokuTable;
    }

    public boolean solveTable() {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (sudokuTable[r][c] == 0) {
                    for (int n = 1; n <= 9; n++) {
                        if (isNumberInBox(r, c, n) && isNumberInCol(c, n) && isNumberInRow(r, n)) {
                            sudokuTable[r][c] = n;
                            if (solveTable()) {
                                return true;
                            } else {
                                sudokuTable[r][c] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public int[][] getSolvedTable() throws SudokuException {
        if (solveTable()) {
            System.out.println(SUDOKU_SOLVED);
            return sudokuTable;
        } else {
            throw new SudokuException(SudokuException.ERR_SUDOKU_NOT_SOLVABLE);
        }
    }

    private boolean isNumberInRow(int r, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudokuTable[r][i] == n) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInCol(int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (sudokuTable[i][c] == n) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(int r, int c, int n) {
        int row = r - r % 3;
        int col = c - c % 3;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (sudokuTable[i][j] == n) {
                    return true;
                }
            }
        }
        return false;
    }

}
