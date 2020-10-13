package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TopKFrequentElementsTests {

    @Test
    public void testSolution() {
        TopKFrequentElements.Solution sol = new TopKFrequentElements().new Solution();
        int[] testArray = {1,1,1,2,2,3};
        int[] expected = new int[]{1,2};
        List<Integer> res = sol.topKFrequent(testArray, 2);
        Integer[] resArray = new Integer[res.size()];
        resArray = res.toArray(resArray);
        assertEquals(expected.length, resArray.length);
        for (int i=0; i<expected.length; i++) {
            assertEquals(expected[i], (int)resArray[i]);
        }
    }

    @Test
    public void testSolution2() {
        TopKFrequentElements.Solution_2 sol = new TopKFrequentElements().new Solution_2();
        int[] testArray = {1,1,1,2,2,3};
        int[] expected = new int[]{1,2};
        List<Integer> res = sol.topKFrequent(testArray, 2);
        Integer[] resArray = new Integer[res.size()];
        resArray = res.toArray(resArray);
        assertEquals(expected.length, resArray.length);
        for (int i=0; i<expected.length; i++) {
            assertEquals(expected[i], (int)resArray[i]);
        }
    }

}
