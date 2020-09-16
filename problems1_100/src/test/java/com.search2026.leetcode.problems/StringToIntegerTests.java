package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringToIntegerTests {

    @Test
    public void testSolution() {
        StringToInteger.Solution sol = new StringToInteger().new Solution();
        assertEquals(0, sol.myAtoi("0"));
        assertEquals(7, sol.myAtoi("7"));
        assertEquals(-1, sol.myAtoi("-1"));
        assertEquals(66666666, sol.myAtoi("66666666"));
        assertEquals(-12345, sol.myAtoi("-12345"));
        assertEquals(2147483647, sol.myAtoi("2147483648"));
    }

}
