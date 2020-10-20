package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindTheDifferenceTests {

    @Test
    public void testSolution() {
        FindTheDifference.Solution sol = new FindTheDifference().new Solution();
        assertEquals('e', sol.findTheDifference_B("abcd", "abcde"));
        assertEquals('e', sol.findTheDifference_B("abcd", "dbcae"));
        assertEquals('e', sol.findTheDifference_B("abcd", "ecadb"));
    }

    @Test
    public void testSolution2() {
        FindTheDifference.Solution_2 sol = new FindTheDifference().new Solution_2();
        assertEquals('e', sol.findTheDifference_B("abcd", "abcde"));
        assertEquals('e', sol.findTheDifference_B("abcd", "dbcae"));
        assertEquals('e', sol.findTheDifference_B("abcd", "ecadb"));
    }

}
