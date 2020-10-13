package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BulbSwitcherTests {

    @Test
    public void test1() {
        BulbSwitcher.Solution sol = new BulbSwitcher().new Solution();
        assertEquals(4, sol.bulbSwitch(18));
    }

}
