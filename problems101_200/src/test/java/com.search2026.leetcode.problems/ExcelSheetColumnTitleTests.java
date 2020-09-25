package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelSheetColumnTitleTests {

    @Test
    public void test1() {
        ExcelSheetColumnTitle.Solution sol = new ExcelSheetColumnTitle().new Solution();
        assertEquals("A", sol.convertToTitle(1));
        assertEquals("AB", sol.convertToTitle(28));
        assertEquals("ZY", sol.convertToTitle(701));
    }

}
