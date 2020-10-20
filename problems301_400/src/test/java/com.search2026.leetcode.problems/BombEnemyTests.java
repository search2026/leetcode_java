package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombEnemyTests {

    @Test
    public void testSolution() {
        BombEnemy.Solution sol = new BombEnemy().new Solution();
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };
        assertEquals(3, sol.maxKilledEnemies(grid));
    }


    @Test
    public void testSolution2() {
        BombEnemy.Solution_2 sol = new BombEnemy().new Solution_2();
        char[][] grid = {
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };
        assertEquals(3, sol.maxKilledEnemies(grid));
    }

}
