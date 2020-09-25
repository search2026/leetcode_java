package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MajorityElementTests {

    @Test
    public void testSolution() {
        MajorityElement.Solution sol = new MajorityElement().new Solution();
        int[] nums = {3, 2, 3};
        assertEquals(3, sol.majorityElement(nums));
        nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        assertEquals(2, sol.majorityElement(nums));
    }

    @Test
    public void testSolution2() {
        MajorityElement.Solution_2 sol = new MajorityElement().new Solution_2();
        int[] nums = {3, 2, 3};
        List<Integer> res = sol.majorityElement(nums);
        assertEquals(1, res.size());
        assertEquals(3, res.get(0));

        nums = new int[]{1};
        res = sol.majorityElement(nums);
        assertEquals(1, res.size());
        assertEquals(1, res.get(0));

        nums = new int[]{1, 2};
        res = sol.majorityElement(nums);
        assertEquals(2, res.size());
        assertEquals(1, res.get(0));
        assertEquals(2, res.get(1));
    }

}
