package com.sudoku.solver;

import com.sudoku.solver.exception.SudokuException;
import com.sudoku.solver.logic.SudokuSolver;
import com.sudoku.solver.logic.SudokuTablePreparation;

public class SudokuRunner {
    public static void main(String[] args) throws SudokuException {
        int[][] sudokuTable, solvedTable;
        SudokuTablePreparation sudokuTablePreparation = new SudokuTablePreparation();
        SudokuSolver sudokuSolver;
        sudokuTable = sudokuTablePreparation.prepareTable();
        sudokuSolver = new SudokuSolver(sudokuTable);
        solvedTable = sudokuSolver.getSolvedTable();
        sudokuTablePreparation.showTable(solvedTable);
    }
}
