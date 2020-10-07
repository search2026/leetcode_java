package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingRangesTests {

    @Test
    public void testSolution() {
        MissingRanges.Solution sol = new MissingRanges().new Solution();
        int[] test = {0, 1, 3, 50, 75};
        List<String> res = sol.findMissingRanges(test, 0, 99);
        assertEquals(4, res.size());
        assertEquals("2", res.get(0));
        assertEquals("4->49", res.get(1));
        assertEquals("51->74", res.get(2));
        assertEquals("76->99", res.get(3));
    }

}
