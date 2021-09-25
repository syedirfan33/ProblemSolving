package com.leetcode;

public class MineSweeper {
    // Solved it myself laaaaa, actually visited is not required.
    boolean[][] visited;
    int[][] dirs;

    public char[][] updateBoard(char[][] board, int[] click) {
        visited = new boolean[board.length][board[0].length];
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j) {
        if (!isValid(i, j, board) || visited[i][j])
            return;
        if (board[i][j] == 'B') {
            visited[i][j] = true;
            return;
        }
        if (board[i][j] == 'M') {
            visited[i][j] = true;
            board[i][j] = 'X';
            return;
        }
        int count = 0;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (isValid(nextI, nextJ, board) && board[nextI][nextJ] == 'M') {
                count++;
            }
        }
        if (count != 0) {
            board[i][j] = (char) (count + '0');
        } else {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                dfs(board, nextI, nextJ);
            }
        }
    }

    private boolean isValid(int i, int j, char[][] board) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }

    // Without ivisted, simple
    /*int[][] dirs;
    public char[][] updateBoard(char[][] board, int[] click) {
        dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int i, int j){
        if(!isValid(i, j, board) ||board[i][j] == 'B')
            return;

        if(board[i][j] == 'M' || board[i][j] == 'X'){
            board[i][j] = 'X';
            return;
        }
        int count = 0;
        for(int[] dir: dirs){
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if(isValid(nextI, nextJ, board) && board[nextI][nextJ] == 'M'){
                count++;
            }
        }
        if(count != 0){
            board[i][j] = (char) (count + '0');
        }else{
            board[i][j] = 'B';
            for(int[] dir: dirs){
                int nextI = i + dir[0];
                int nextJ = j + dir[1];
                dfs(board, nextI, nextJ);
            }
        }
    }

    private boolean isValid(int i, int j, char[][] board){
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }*/
}
