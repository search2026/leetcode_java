package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindMedianFromDataStreamTests {

    @Test
    public void testSolution() {
        FindMedianFromDataStream.MedianFinder sol = new FindMedianFromDataStream().new MedianFinder();
        sol.addNum(2);
        sol.addNum(3);
        assertEquals(2.5, sol.findMedian(), 1E-03);
        sol.addNum(4);
        assertEquals(3, sol.findMedian(), 1E-03);
    }

}
