package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCombinationSum {

    @Test
    public void test1() {
        CombinationSum.Solution sol = new CombinationSum().new Solution();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> comb = sol.combinationSum(candidates, 7);
        assertEquals(2, comb.size());
        assertEquals(3, comb.get(0).size());
        assertEquals(2, (int) comb.get(0).get(0));
        assertEquals(2, (int) comb.get(0).get(1));
        assertEquals(3, (int) comb.get(0).get(2));
        assertEquals(1, comb.get(1).size());
        assertEquals(7, (int) comb.get(1).get(0));
    }

    @Test
    public void test2() {
        CombinationSum.Solution_2 sol = new CombinationSum().new Solution_2();
        int[] candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> comb = sol.combinationSum(candidates, 7);
        assertEquals(2, comb.size());
        assertEquals(3, comb.get(0).size());
        assertEquals(2, (int) comb.get(0).get(0));
        assertEquals(2, (int) comb.get(0).get(1));
        assertEquals(3, (int) comb.get(0).get(2));
        assertEquals(1, comb.get(1).size());
        assertEquals(7, (int) comb.get(1).get(0));
    }

    @Test
    public void test3() {
        CombinationSum.Solution_3 sol = new CombinationSum().new Solution_3();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> comb = sol.combinationSum2(candidates, 8);
        assertEquals(4, comb.size());
        assertEquals(3, comb.get(0).size());
        assertEquals(1, (int) comb.get(0).get(0));
        assertEquals(1, (int) comb.get(0).get(1));
        assertEquals(6, (int) comb.get(0).get(2));
        assertEquals(3, comb.get(1).size());
        assertEquals(1, (int) comb.get(1).get(0));
        assertEquals(2, (int) comb.get(1).get(1));
        assertEquals(5, (int) comb.get(1).get(2));
        assertEquals(2, comb.get(2).size());
        assertEquals(1, (int) comb.get(2).get(0));
        assertEquals(7, (int) comb.get(2).get(1));
        assertEquals(2, comb.get(3).size());
        assertEquals(2, (int) comb.get(3).get(0));
        assertEquals(6, (int) comb.get(3).get(1));
    }

    @Test
    public void test4() {
        CombinationSum.Solution_4 sol = new CombinationSum().new Solution_4();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> combo = sol.combinationSum2(candidates, 8);
        // assertEquals(4, combo.size());
    }

    @Test
    public void test5() {
        CombinationSum.Solution_5 sol = new CombinationSum().new Solution_5();
        List<List<Integer>> combo = sol.combinationSum3(3, 7);
        assertEquals(1, combo.size());
        assertEquals(3, combo.get(0).size());
        assertEquals(1, (int) combo.get(0).get(0));
        assertEquals(2, (int) combo.get(0).get(1));
        assertEquals(4, (int) combo.get(0).get(2));

        combo = sol.combinationSum3(3, 9);
        assertEquals(3, combo.size());
        assertEquals(3, combo.get(0).size());
        assertEquals(1, (int) combo.get(0).get(0));
        assertEquals(2, (int) combo.get(0).get(1));
        assertEquals(6, (int) combo.get(0).get(2));
        assertEquals(3, combo.get(1).size());
        assertEquals(1, (int) combo.get(1).get(0));
        assertEquals(3, (int) combo.get(1).get(1));
        assertEquals(5, (int) combo.get(1).get(2));
        assertEquals(3, combo.get(2).size());
        assertEquals(2, (int) combo.get(2).get(0));
        assertEquals(3, (int) combo.get(2).get(1));
        assertEquals(4, (int) combo.get(2).get(2));
    }

    @Test
    public void test6() {
        CombinationSum.Solution_6 sol = new CombinationSum().new Solution_6();
        assertEquals(7, sol.combinationSum4(new int[]{1, 3, 2}, 4));
    }

}
