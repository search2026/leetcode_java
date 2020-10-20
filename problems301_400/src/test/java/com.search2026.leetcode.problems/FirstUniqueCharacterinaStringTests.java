package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstUniqueCharacterinaStringTests {

    @Test
    public void testSolution() {
        FirstUniqueCharacterInAString.Solution sol = new FirstUniqueCharacterInAString().new Solution();
        assertEquals(4, sol.firstUniqChar("google"));
        assertEquals(0, sol.firstUniqChar("facebook"));
    }

}
