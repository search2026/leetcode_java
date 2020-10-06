package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactorCombinationsTests {

    @Test
    public void test1() {
        FactorCombinations.Solution sol = new FactorCombinations().new Solution();
        List<List<Integer>> res = sol.getFactors(1);
        assertEquals(0, res.size());

        res = sol.getFactors(37);
        assertEquals(0, res.size());

        res = sol.getFactors(12);
        assertEquals(3, res.size());

        res = sol.getFactors(32);
        assertEquals(6, res.size());
    }

}
