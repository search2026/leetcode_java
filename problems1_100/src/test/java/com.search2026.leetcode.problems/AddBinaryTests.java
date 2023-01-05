package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddBinaryTests {

    @Test
    public void testSolution() {
        AddBinary.Solution sol = new AddBinary.Solution();
        assertEquals("0", sol.addBinary("0", "0"));
        assertEquals("100", sol.addBinary("11", "1"));
        assertEquals("10110", sol.addBinary("11", "10011"));
        assertEquals("10101", sol.addBinary("1011", "1010"));
    }

}
