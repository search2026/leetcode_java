package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfConnectedComponentsInAnUndirectedGraphTests {

    @Test
    public void testSolution() {
        NumberOfConnectedComponentsInAnUndirectedGraph.Solution sol =
                new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        assertEquals(2, sol.countComponents(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        };
        assertEquals(1, sol.countComponents(n, edges));
    }

    @Test
    public void testSolution2() {
        NumberOfConnectedComponentsInAnUndirectedGraph.Solution_2 sol =
                new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution_2();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        assertEquals(2, sol.countComponents(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        };
        assertEquals(1, sol.countComponents(n, edges));
    }

    @Test
    public void testSolution3() {
        NumberOfConnectedComponentsInAnUndirectedGraph.Solution_3 sol =
                new NumberOfConnectedComponentsInAnUndirectedGraph().new Solution_3();
        int n = 5;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        assertEquals(2, sol.countComponents(n, edges));

        n = 5;
        edges = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        };
        assertEquals(1, sol.countComponents(n, edges));
    }

}
