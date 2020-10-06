package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GraphValidTreeTests {

    @Test
    public void testSolution() {
        GraphValidTree.Solution sol = new GraphValidTree().new Solution();
        int n = 5;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1, 4}
        };
        assertTrue(sol.validTree(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4}
        };
        assertFalse(sol.validTree(n, edges));
    }

    @Test
    public void testSolution2() {
        GraphValidTree.Solution_2 sol = new GraphValidTree().new Solution_2();
        int n = 5;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1, 4}
        };
        assertTrue(sol.validTree(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4}
        };
        assertFalse(sol.validTree(n, edges));
    }

    @Test
    public void testSolution3() {
        GraphValidTree.Solution_3 sol = new GraphValidTree().new Solution_3();
        int n = 5;
        int[][] edges = new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 3},
                new int[]{1, 4}
        };
        assertTrue(sol.validTree(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{1, 3},
                new int[]{1, 4}
        };
        assertFalse(sol.validTree(n, edges));
    }

}
