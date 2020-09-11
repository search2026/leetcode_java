package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestRestoreIPAddresses {

    @Test
    public void test1() {
        RestoreIPAddresses.Solution sol = new RestoreIPAddresses().new Solution();
        List<String> res = sol.restoreIpAddresses("25525511135");
        assertEquals(2, res.size());
        assertTrue(res.contains("255.255.11.135"));
        assertTrue(res.contains("255.255.111.35"));
    }

    @Test
    public void test2() {
        RestoreIPAddresses.Solution_2 sol = new RestoreIPAddresses().new Solution_2();
        List<String> res = sol.restoreIpAddresses("25525511135");
        assertEquals(2, res.size());
        assertTrue(res.contains("255.255.11.135"));
        assertTrue(res.contains("255.255.111.35"));
    }

}
