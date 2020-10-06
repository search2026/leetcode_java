package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddDigitsTests {

    @Test
    public void test1() {
        AddDigits.Solution sol = new AddDigits().new Solution();
        assertEquals(2, sol.addDigits(38));
    }

}
