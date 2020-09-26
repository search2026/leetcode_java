package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfIslandsTests {

    @Test
    public void testSolution() {
        NumberOfIslands.Solution sol = new NumberOfIslands().new Solution();
        char[][] island = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        assertEquals(1, sol.numIslands(island));

        island = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        assertEquals(3, sol.numIslands(island));
    }

    @Test
    public void testSolution2() {
        NumberOfIslands.Solution_2 sol = new NumberOfIslands().new Solution_2();
        char[][] island = new char[][]{
                new char[]{'1', '1', '1', '1', '0'},
                new char[]{'1', '1', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '0'},
                new char[]{'0', '0', '0', '0', '0'}
        };
        assertEquals(1, sol.numIslands(island));

        island = new char[][]{
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'1', '1', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0'},
                new char[]{'0', '0', '0', '1', '1'}
        };
        assertEquals(3, sol.numIslands(island));
    }

    @Test
    public void testSolution4() {
        NumberOfIslands.Solution_4 sol = new NumberOfIslands().new Solution_4();

        int[][] positions = new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        };
        // positions[0][0] = 1;
        List<Integer> res = sol.numIslands2(3, 3, positions);

        assertEquals(positions.length, res.size());
        assertEquals(1, (int)res.get(0));
        assertEquals(1, (int)res.get(1));
        assertEquals(2, (int)res.get(2));
        assertEquals(3, (int)res.get(3));
    }

    @Test
    public void testSolution5() {
        NumberOfIslands.Solution_5 sol = new NumberOfIslands().new Solution_5();

        int[][] positions = new int[][]{
                {0, 0},
                {0, 1},
                {1, 2},
                {2, 1}
        };
        // positions[0][0] = 1;
        List<Integer> res = sol.numIslands2(3, 3, positions);

        assertEquals(positions.length, res.size());
        assertEquals(1, (int)res.get(0));
        assertEquals(1, (int)res.get(1));
        assertEquals(2, (int)res.get(2));
        assertEquals(3, (int)res.get(3));
    }

}
