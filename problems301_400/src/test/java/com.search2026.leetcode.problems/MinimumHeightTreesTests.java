package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MinimumHeightTreesTests {

    @Test
    public void testSolution() {
        MinimumHeightTrees.Solution sol = new MinimumHeightTrees().new Solution();
        int n = 4;
        int[][] edges = new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{1, 3}
        };
        List<Integer> res = sol.findMinHeightTrees(n, edges);
        int[] tmpArray = toIntArray(res);
        assertArrayEquals(new int[]{1}, tmpArray);

        n = 6;
        edges = new int[][]{
                new int[]{0, 3},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{4, 3},
                new int[]{5, 4}
        };
        res = sol.findMinHeightTrees(n, edges);
        tmpArray = toIntArray(res);
        assertArrayEquals(new int[]{3, 4}, tmpArray);
    }

    int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e;
        return ret;
    }

}
