package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingRangesTests {

    @Test
    public void testSolution() {
        MissingRanges.Solution sol = new MissingRanges().new Solution();
        int[] test = {0, 1, 3, 50, 75};
        List<String> results = sol.findMissingRanges(test, 0, 99);
        assertEquals(4, results.size());
        assertEquals("2", results.get(0));
        assertEquals("4->49", results.get(1));
        assertEquals("51->74", results.get(2));
        assertEquals("76->99", results.get(3));
    }

}
