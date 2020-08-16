package com.sudoku.solver.exception;

public class SudokuException extends Exception {

    public static final String ERR_INDEX_OUT_OF_BOUNDS = "<<Podane wartosci powinny byc z zakresu od 1 do 9>>";
    public static final String ERR_SUDOKU_NOT_SOLVABLE = "<<Podana siatka Sudoku jest niemozliwa do rozwiazania>>";

    public SudokuException(String message) {
        super(message);
    }

}
