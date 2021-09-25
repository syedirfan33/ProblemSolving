package com.leetcode;

public class TicTacToe {
    int[][] board;
    int[] rows;
    int[] cols;
    int diagScore;
    int antiDiagScore;
    int size = 3;
    int move = 0;
    String winner;

    public TicTacToe() {
        board = new int[size][size];
        rows = new int[size];
        cols = new int[size];
        diagScore = 0;
        antiDiagScore = 0;
        winner = "";
    }

    public boolean move(int row, int col) throws AlreadyTakenException, GameEndException {

        if (!winner.equals("")) {
            throw new GameEndException();
        }
        if (board[row][col] != 0) {
            throw new AlreadyTakenException();
        }
        String player = move % 2 == 0 ? "x" : "o";
        int moveScore = move % 2 == 0 ? 1 : -1;
        board[row][col] = moveScore;

        rows[row] += moveScore;
        cols[col] += moveScore;
        if (row == col) {
            diagScore += moveScore;
        }
        if (row == size - 1 - col) {
            antiDiagScore += moveScore;
        }
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(diagScore) == size || Math.abs(antiDiagScore) == size) {
            winner = player;
            System.out.println(player + " player wins!");
            return true;
        }

        move++;
        if (move == size * size) {
            System.out.println("It's a draw");
            return false;
        }return false;
    }
}

class AlreadyTakenException extends Exception {
    AlreadyTakenException() {
        super();
    }
}

class GameEndException extends Exception {
    GameEndException() {
        super();
    }
}
