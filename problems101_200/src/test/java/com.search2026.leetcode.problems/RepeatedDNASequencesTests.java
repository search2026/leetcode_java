package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatedDNASequencesTests {

    @Test
    public void testSolution() {
        RepeatedDNASequences.Solution sol = new RepeatedDNASequences().new Solution();
        List<String> res = sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertEquals(2, res.size());
        assertTrue(res.contains("AAAAACCCCC"));
        assertTrue(res.contains("CCCCCAAAAA"));
    }

}
