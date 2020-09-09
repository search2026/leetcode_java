package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCountAndSay {

    @Test
    public void test1() {
        CountAndSay.Solution sol = new CountAndSay().new Solution();
        assertEquals("1", sol.countAndSay(1));
        assertEquals("1211", sol.countAndSay(4));
    }

}
