package com.search2026.leetcode.problems;

import java.util.LinkedList;

public class SurroundedRegions {

    /*
        Surrounded Regions
        Leetcode #130
        https://leetcode.com/problems/surrounded-regions/
        Difficulty: Medium
     */
    public class Solution {
        private void search(char[][] board, int i, int j) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(i * board[0].length + j);
            board[i][j] = '$';
            while (queue.size() != 0) {
                int num = queue.poll();
                int row = num / board[0].length;
                int col = num % board[0].length;

                if (row > 0 && board[row - 1][col] == 'O') {
                    queue.offer((row - 1) * board[0].length + col);
                    board[row - 1][col] = '$';
                }
                if (row < board.length - 1 && board[row + 1][col] == 'O') {
                    queue.offer((row + 1) * board[0].length + col);
                    board[row + 1][col] = '$';
                }
                if (col > 0 && board[row][col - 1] == 'O') {
                    queue.offer(row * board[0].length + col - 1);
                    board[row][col - 1] = '$';
                }
                if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
                    queue.offer(row * board[0].length + col + 1);
                    board[row][col + 1] = '$';
                }
            }
        }

        public void solve(char[][] board) {
            if (board == null || board.length == 0 || board[0].length == 0) return;
            for (int j = 0; j < board[0].length; j++) {
                if (board[0][j] == 'O') search(board, 0, j);
                if (board[board.length - 1][j] == 'O') search(board, board.length - 1, j);
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 'O') search(board, i, 0);
                if (board[i][board[0].length - 1] == 'O') search(board, i, board[0].length - 1);
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == '$') board[i][j] = 'O';
                    else if (board[i][j] == 'O') board[i][j] = 'X';
                }
            }
        }
    }

}
