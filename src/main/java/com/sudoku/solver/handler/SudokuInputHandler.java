package com.sudoku.solver.handler;

import java.util.Scanner;

public class SudokuInputHandler {
    Scanner in;

    public void initHandler() {
        in = new Scanner(System.in);
    }

    public String readForNexLine() {
        return in.nextLine();
    }
}
