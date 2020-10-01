package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShortestWordDistanceTests {

    @Test
    public void testSolution() {
        ShortestWordDistance.Solution sol = new ShortestWordDistance().new Solution();
        String[] test = {"practice", "makes", "perfect", "coding", "makes"};
        assertEquals(3, sol.shortestDistance(test, "coding", "practice"));
        assertEquals(1, sol.shortestDistance(test, "coding", "makes"));
        assertEquals(1, sol.shortestDistance(test, "makes", "coding"));
    }

    @Test
    public void testSolution2() {
        String[] test = {"the", "quick", "brown", "fox", "quick"};
        ShortestWordDistance.WordDistance sol = new ShortestWordDistance().new WordDistance(test);
        assertEquals(3, sol.shortest("fox", "the"));
        assertEquals(1, sol.shortest("quick", "fox"));
        assertEquals(1, sol.shortest("fox", "quick"));
    }

    @Test
    public void testSolution3() {
        ShortestWordDistance.Solution_3 sol = new ShortestWordDistance().new Solution_3();
        String[] test = {"practice", "makes", "perfect", "coding", "makes"};
        assertEquals(3, sol.shortestWordDistance(test, "coding", "practice"));
        assertEquals(1, sol.shortestWordDistance(test, "coding", "makes"));
        assertEquals(1, sol.shortestWordDistance(test, "makes", "coding"));
        assertEquals(3, sol.shortestWordDistance(test, "makes", "makes"));
    }

}
