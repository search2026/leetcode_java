package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPermutationSequence {

    @Test
    public void test1() {
        PermutationSequence.Solution sol = new PermutationSequence().new Solution();
        assertEquals(sol.getPermutation(4, 17), "3412");
    }

}
