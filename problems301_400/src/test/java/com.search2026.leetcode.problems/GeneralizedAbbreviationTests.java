package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GeneralizedAbbreviationTests {

    @Test
    public void testSolution() {
        GeneralizedAbbreviation.Solution sol = new GeneralizedAbbreviation().new Solution();
        List<String> res = sol.generateAbbreviations("word");
        assertEquals(16, res.size());
        assertTrue(res.contains("word"));
        assertTrue(res.contains("1ord"));
        assertTrue(res.contains("w1rd"));
        assertTrue(res.contains("wo1d"));
        assertTrue(res.contains("wor1"));
        assertTrue(res.contains("2rd"));
        assertTrue(res.contains("w2d"));
        assertTrue(res.contains("wo2"));
        assertTrue(res.contains("1o1d"));
        assertTrue(res.contains("1or1"));
        assertTrue(res.contains("w1r1"));
        assertTrue(res.contains("1o2"));
        assertTrue(res.contains("2r1"));
        assertTrue(res.contains("3d"));
        assertTrue(res.contains("w3"));
        assertTrue(res.contains("4"));
    }

}
