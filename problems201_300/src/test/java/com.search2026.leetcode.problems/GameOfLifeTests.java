package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOfLifeTests {

    @Test
    public void testSolution() {
        GameOfLife.Solution sol = new GameOfLife().new Solution();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        sol.gameOfLife(board);
        assertEquals(4, board.length);
        assertArrayEquals(new int[]{0, 0, 0}, board[0]);
        assertArrayEquals(new int[]{1, 0, 1}, board[1]);
        assertArrayEquals(new int[]{0, 1, 1}, board[2]);
        assertArrayEquals(new int[]{0, 1, 0}, board[3]);
    }
    @Test
    public void testSolution2() {
        GameOfLife.Solution_2 sol = new GameOfLife().new Solution_2();
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        sol.gameOfLife(board);
        assertEquals(4, board.length);
        assertArrayEquals(new int[]{0, 0, 0}, board[0]);
        assertArrayEquals(new int[]{1, 0, 1}, board[1]);
        assertArrayEquals(new int[]{0, 1, 1}, board[2]);
        assertArrayEquals(new int[]{0, 1, 0}, board[3]);
    }

}
