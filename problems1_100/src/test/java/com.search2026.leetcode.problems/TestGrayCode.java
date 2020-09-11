package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGrayCode {

    @Test
    public void test1() {
        GrayCode.Solution sol = new GrayCode().new Solution();
        List<Integer> grayCodes = sol.grayCode(2);
        assertEquals(4, grayCodes.size());
        assertEquals(0, (int) grayCodes.get(0));
        assertEquals(1, (int) grayCodes.get(1));
        assertEquals(3, (int) grayCodes.get(2));
        assertEquals(2, (int) grayCodes.get(3));
    }

    @Test
    public void test2() {
        GrayCode.Solution_2 sol = new GrayCode().new Solution_2();
        List<Integer> grayCodes = sol.grayCode(2);
        assertEquals(4, grayCodes.size());
        assertEquals(0, (int) grayCodes.get(0));
        assertEquals(1, (int) grayCodes.get(1));
        assertEquals(3, (int) grayCodes.get(2));
        assertEquals(2, (int) grayCodes.get(3));
    }

}
