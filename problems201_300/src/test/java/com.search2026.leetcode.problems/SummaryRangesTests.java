package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SummaryRangesTests {

    @Test
    public void testSolution() {
        SummaryRanges.Solution sol = new SummaryRanges().new Solution();
        List<String> res = sol.summaryRanges(new int[]{0,1,2,4,5,7});
        assertEquals(3, res.size());
        assertEquals("0->2", res.get(0));
        assertEquals("4->5", res.get(1));
        assertEquals("7", res.get(2));

        res = sol.summaryRanges(new int[]{0,2,3,4,6,8,9});
        assertEquals(4, res.size());
        assertEquals("0", res.get(0));
        assertEquals("2->4", res.get(1));
        assertEquals("6", res.get(2));
        assertEquals("8->9", res.get(3));
    }

}
