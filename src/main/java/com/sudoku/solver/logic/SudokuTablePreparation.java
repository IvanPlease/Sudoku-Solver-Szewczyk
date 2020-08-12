package com.sudoku.solver.logic;
import com.sudoku.solver.communication.SudokuCommunication;
import com.sudoku.solver.exception.SudokuException;
import com.sudoku.solver.handler.SudokuInputHandler;

import static com.sudoku.solver.communication.SudokuCommunication.askForOutput;

public class SudokuTablePreparation {

    private final static String SEARCH_TERM = "SUDOKU";
    SudokuInputHandler inputHandler;

    public SudokuTablePreparation() {
        inputHandler = new SudokuInputHandler();
    }

    public int[][] prepareTable() throws SudokuException {
        int[][] sudokuTable = new int[9][9];
        String nextLine;
        inputHandler.initHandler();
        askForOutput(SudokuCommunication.ASK_FOR_INPUT);
        nextLine = inputHandler.readForNexLine();
        while(!nextLine.equals(SEARCH_TERM)) {
            int[] posAndValue = splitToInt(nextLine.split("(?!^)"));
            boolean checkIfCorrectX = posAndValue[0] > 0 && posAndValue[0] < 10;
            boolean checkIfCorrectY = posAndValue[1] > 0 && posAndValue[1] < 10;
            boolean checkIfCorrectV = posAndValue[2] > 0 && posAndValue[2] < 10;
            posAndValue[0]--;
            posAndValue[1]--;
            if(checkIfCorrectV && checkIfCorrectY && checkIfCorrectX){
                sudokuTable[posAndValue[0]][posAndValue[1]] = posAndValue[2];
            }else{
                throw new SudokuException(SudokuException.ERR_INDEX_OUT_OF_BOUNDS);
            }
            showTable(sudokuTable);
            askForOutput(SudokuCommunication.ASK_FOR_INPUT);
            nextLine = inputHandler.readForNexLine();
        }
        return sudokuTable;
    }

    public void showTable(int[][] table){
        int j=0;
        int i=0;
        System.out.println("┌───┬───┬───┬───┬───┬───┬───┬───┬───┐");
        for(int[] value:table){
            for(int val:value){
                j++;
                if(j==1){
                    System.out.print("├ " + val);
                }else{
                    System.out.print(" ┼ " + val);
                }
                if(j==9){
                    System.out.println(" ┤");
                    j=0;
                }
            }
            i++;
            if(i!=9){
                System.out.println("├───┼───┼───┼───┼───┼───┼───┼───┼───┤");
            }
        }
        System.out.println("└───┴───┴───┴───┴───┴───┴───┴───┴───┘");
    }

    public int[] splitToInt(String[] posAndValue){
        int[] splitted = new int[3];
        int index = 0;
        for(String value:posAndValue){
            splitted[index] = Integer.parseInt(value);
            index++;
        }
        return splitted;
    }
}
