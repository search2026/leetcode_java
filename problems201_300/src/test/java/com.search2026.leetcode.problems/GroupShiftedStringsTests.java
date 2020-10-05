package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GroupShiftedStringsTests {

    @Test
    public void testSolution() {
        GroupShiftedStrings.Solution sol = new GroupShiftedStrings().new Solution();
        String[] strs = {"az", "z", "abc", "ba", "xyz", "acef", "a", "bcd"};
        List<List<String>> res = sol.groupStrings(strs);
        assertEquals(4, res.size());
    }

}
