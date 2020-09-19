package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class SurroundedRegionsTests {

    @Test
    public void testSolution() {
        SurroundedRegions.Solution sol = new SurroundedRegions().new Solution();
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        sol.solve(board);
        assertEquals(4, board.length);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[0]);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[1]);
        assertArrayEquals(new char[]{'X', 'X', 'X', 'X'}, board[2]);
        assertArrayEquals(new char[]{'X', 'O', 'X', 'X'}, board[3]);
    }

}
