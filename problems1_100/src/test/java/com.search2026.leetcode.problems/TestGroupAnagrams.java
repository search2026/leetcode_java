package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestGroupAnagrams {

    @Test
    public void test1() {
        GroupAnagrams.Solution sol = new GroupAnagrams().new Solution();
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        // expected output [["bat"],["nat","tan"],["ate","eat","tea"]]
        List<List<String>> res = sol.groupAnagrams(strs);
        assertEquals(3, res.size());
    }
}
