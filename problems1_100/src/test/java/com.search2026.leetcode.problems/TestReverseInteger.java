package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestReverseInteger {

    @Test
    public void test1() {
        ReverseInteger.Solution sol = new ReverseInteger().new Solution();
        assertEquals(0, sol.reverse(0));
        assertEquals(1, sol.reverse(1000));
        assertEquals(321, sol.reverse(123));
        assertEquals(-75563, sol.reverse(-36557));
    }

}
