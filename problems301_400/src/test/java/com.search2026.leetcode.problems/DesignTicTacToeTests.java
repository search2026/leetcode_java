package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DesignTicTacToeTests {

    @Test
    public void testSolution() {
        DesignTicTacToe.TicTacToe sol = new DesignTicTacToe().new TicTacToe(3);
        assertEquals(0, sol.move(0, 0, 1));
        assertEquals(0, sol.move(0, 2, 2));
        assertEquals(0, sol.move(2, 2, 1));
        assertEquals(0, sol.move(1, 1, 2));
        assertEquals(0, sol.move(2, 0, 1));
        assertEquals(0, sol.move(1, 0, 2));
        assertEquals(1, sol.move(2, 1, 1));
    }

}
