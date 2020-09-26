package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelSheetColumnNumberTests {

    @Test
    public void testSolution() {
        ExcelSheetColumnNumber.Solution sol = new ExcelSheetColumnNumber().new Solution();
        assertEquals(1, sol.titleToNumber("A"));
        assertEquals(28, sol.titleToNumber("AB"));
        assertEquals(701, sol.titleToNumber("ZY"));
    }

}
