package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordLadderTests {

    @Test
    public void testSolution() {
        WordLadder.Solution sol = new WordLadder().new Solution();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        assertEquals(5, sol.ladderLength("hit", "cog", dict));
    }

    @Test
    public void testSolution2() {
        WordLadder.Solution_2 sol = new WordLadder().new Solution_2();
        Set<String> dict = new HashSet<>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        List<List<String>> res = sol.findLadders ("hit", "cog", dict);
        assertEquals(2, res.size());
    }

}
