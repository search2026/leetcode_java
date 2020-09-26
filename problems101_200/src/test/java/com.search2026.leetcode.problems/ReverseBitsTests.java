package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseBitsTests {

    @Test
    public void testSolution() {
        ReverseBits.Solution sol = new ReverseBits().new Solution();
        assertEquals(964176192, sol.reverseBits(43261596));
    }

    @Test
    public void testSolution2() {
        ReverseBits.Solution_2 sol = new ReverseBits().new Solution_2();
        assertEquals(964176192, sol.reverseBits(43261596));
    }

    @Test
    public void testSolution3() {
        ReverseBits.Solution_3 sol = new ReverseBits().new Solution_3();
        assertEquals(964176192, sol.reverseBits(43261596));
    }

}
