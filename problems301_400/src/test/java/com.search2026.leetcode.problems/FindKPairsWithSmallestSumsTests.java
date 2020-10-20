package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindKPairsWithSmallestSumsTests {

    @Test
    public void testSolution() {
        FindKPairsWithSmallestSums.Solution sol = new FindKPairsWithSmallestSums().new Solution();
        int[] test1 = {1, 7, 11};
        int[] test2 = {2, 4, 6};
        List<int[]> res = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(3, res.size());
        assertEquals(2, res.get(0).length);
        assertEquals(1, res.get(0)[0]);
        assertEquals(2, res.get(0)[1]);
        assertEquals(2, res.get(1).length);
        assertEquals(1, res.get(1)[0]);
        assertEquals(4, res.get(1)[1]);
        assertEquals(2, res.get(2).length);
        assertEquals(1, res.get(2)[0]);
        assertEquals(6, res.get(2)[1]);

        test1 = new int[]{1, 1, 2};
        test2 = new int[]{1, 2, 3};
        res = sol.kSmallestPairs(test1, test2, 2);
        assertEquals(2, res.size());
        assertEquals(2, res.get(0).length);
        assertEquals(1, res.get(0)[0]);
        assertEquals(1, res.get(0)[1]);
        assertEquals(2, res.get(1).length);
        assertEquals(1, res.get(1)[0]);
        assertEquals(1, res.get(1)[1]);

        test1 = new int[]{1, 2};
        test2 = new int[]{3};
        res = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(2, res.size());
        assertEquals(2, res.get(0).length);
        assertEquals(1, res.get(0)[0]);
        assertEquals(3, res.get(0)[1]);
        assertEquals(2, res.get(1).length);
        assertEquals(2, res.get(1)[0]);
        assertEquals(3, res.get(1)[1]);
    }

    @Test
    public void testSolution2() {
        FindKPairsWithSmallestSums.Solution_2 sol = new FindKPairsWithSmallestSums().new Solution_2();
        int[] test1 = {1, 7, 11};
        int[] test2 = {2, 4, 6};
        List<int[]> result = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(3, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(2, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(1, result.get(1)[0]);
        assertEquals(4, result.get(1)[1]);
        assertEquals(2, result.get(2).length);
        assertEquals(1, result.get(2)[0]);
        assertEquals(6, result.get(2)[1]);

        test1 = new int[]{1, 1, 2};
        test2 = new int[]{1, 2, 3};
        result = sol.kSmallestPairs(test1, test2, 2);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(1, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(1, result.get(1)[0]);
        assertEquals(1, result.get(1)[1]);

        test1 = new int[]{1, 2};
        test2 = new int[]{3};
        result = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(3, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(2, result.get(1)[0]);
        assertEquals(3, result.get(1)[1]);
    }

    @Test
    public void testSolution3() {
        FindKPairsWithSmallestSums.Solution_3 sol = new FindKPairsWithSmallestSums().new Solution_3();
        int[] test1 = {1, 7, 11};
        int[] test2 = {2, 4, 6};
        List<int[]> result = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(3, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(2, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(1, result.get(1)[0]);
        assertEquals(4, result.get(1)[1]);
        assertEquals(2, result.get(2).length);
        assertEquals(1, result.get(2)[0]);
        assertEquals(6, result.get(2)[1]);

        test1 = new int[]{1, 1, 2};
        test2 = new int[]{1, 2, 3};
        result = sol.kSmallestPairs(test1, test2, 2);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(1, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(1, result.get(1)[0]);
        assertEquals(1, result.get(1)[1]);

        test1 = new int[]{1, 2};
        test2 = new int[]{3};
        result = sol.kSmallestPairs(test1, test2, 3);
        assertEquals(2, result.size());
        assertEquals(2, result.get(0).length);
        assertEquals(1, result.get(0)[0]);
        assertEquals(3, result.get(0)[1]);
        assertEquals(2, result.get(1).length);
        assertEquals(2, result.get(1)[0]);
        assertEquals(3, result.get(1)[1]);
    }

}
