package com.sudoku.solver.communication;

public class SudokuCommunication {
    public static final String ASK_FOR_INPUT = "Podaj pozycje oraz wartosc liczby (xyvalue), lub wpisz SUDOKU aby zaczaczac obliczac: ";

    public static void askForOutput(String message) {
        System.out.println(message);
    }

}
