package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAllAnagramsInAStringTests {

    @Test
    public void testSolution() {
        FindAllAnagramsInAString.Solution sol = new FindAllAnagramsInAString().new Solution();
        List<Integer> res = sol.findAnagrams("cbaebabacd", "abc");
        assertEquals(2, res.size());
        assertEquals(0, (int) res.get(0));
        assertEquals(6, (int) res.get(1));

        res = sol.findAnagrams("abab", "ab");
        assertEquals(3, res.size());
        assertEquals(0, (int) res.get(0));
        assertEquals(1, (int) res.get(1));
        assertEquals(2, (int) res.get(2));
    }

}
