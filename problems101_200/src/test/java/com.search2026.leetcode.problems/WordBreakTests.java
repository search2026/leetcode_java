package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordBreakTests {

    @Test
    public void testSolution() {
        WordBreak.Solution sol = new WordBreak().new Solution();
        List<String> list = new ArrayList<>();
        list.add("life");
        list.add("code");
        assertTrue(sol.wordBreak("codelife", list));
        assertTrue(sol.wordBreak("lifecode", list));
        assertFalse(sol.wordBreak("code-life", list));
    }

    @Test
    public void testSolution2() {
        WordBreak.Solution_2 sol = new WordBreak().new Solution_2();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("sand");
        list.add("and");
        list.add("dog");
        List<String> res = sol.wordBreak("catsanddog", list);
        assertEquals(2, res.size());
        assertTrue(res.get(0).equals("cat sand dog"));
        assertTrue(res.get(1).equals("cats and dog"));
    }

    @Test
    public void testSolution3() {
        WordBreak.Solution_3 sol = new WordBreak().new Solution_3();
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("sand");
        list.add("and");
        list.add("dog");
        List<String> res = sol.wordBreak("catsanddog", list);
        assertEquals(2, res.size());
        assertTrue(res.get(0).equals("cats and dog"));
        assertTrue(res.get(1).equals("cat sand dog"));
    }

}
