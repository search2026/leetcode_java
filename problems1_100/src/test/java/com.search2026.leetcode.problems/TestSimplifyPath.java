package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSimplifyPath {

    @Test
    public void test1() {
        SimplifyPath.Solution sol = new SimplifyPath().new Solution();
        assertEquals("/home", sol.simplifyPath("/home/"));
        assertEquals("/", sol.simplifyPath("/../"));
    }

}
