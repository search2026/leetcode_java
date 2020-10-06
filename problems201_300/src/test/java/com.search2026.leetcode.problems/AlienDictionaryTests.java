package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlienDictionaryTests {

    @Test
    public void testSolution() {
        AlienDictionary.Solution sol = new AlienDictionary().new Solution();
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        assertEquals("wertf", sol.alienOrder(words));
    }

    @Test
    public void testSolution2() {
        AlienDictionary.Solution_2 sol = new AlienDictionary().new Solution_2();
        String[] words = {
                "wrt",
                "wrf",
                "er",
                "ett",
                "rftt"
        };
        assertEquals("wertf", sol.alienOrder(words));
    }

}
