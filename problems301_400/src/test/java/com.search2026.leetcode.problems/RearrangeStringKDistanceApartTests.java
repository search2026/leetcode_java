package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RearrangeStringKDistanceApartTests {

    @Test
    public void testSolution() {
        RearrangeStringKDistanceApart.Solution sol = new RearrangeStringKDistanceApart().new Solution();
        String res = sol.rearrangeString("aabbcc", 3);
        assertEquals("acbacb", res);
        res = sol.rearrangeString("aaabc", 3);
        assertEquals("", res);
        res = sol.rearrangeString("aaadbbcc", 2);
        assertEquals("abcabcad", res);
    }

    @Test
    public void testSolution2() {
        RearrangeStringKDistanceApart.Solution_2 sol = new RearrangeStringKDistanceApart().new Solution_2();
        String res = sol.rearrangeString("aabbcc", 3);
        assertEquals("abcabc", res);
        res = sol.rearrangeString("aaabc", 3);
        assertEquals("", res);
        res = sol.rearrangeString("aaadbbcc", 2);
        assertEquals("abacabcd", res);
    }

}
