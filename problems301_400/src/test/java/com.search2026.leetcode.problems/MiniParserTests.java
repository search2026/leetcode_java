package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.NestedInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiniParserTests {

    @Test
    public void testSolution() {
        MiniParser.Solution sol = new MiniParser().new Solution();
        NestedInteger res = sol.deserialize("324");
        assertEquals(324, (int) res.getInteger());
        res = sol.deserialize("[123,[456,[789]]]");
        assertEquals(2, (int) res.getList().size());
    }

    @Test
    public void testSolution2() {
        MiniParser.Solution_2 sol = new MiniParser().new Solution_2();
        NestedInteger res = sol.deserialize("324");
        assertEquals(324, (int) res.getInteger());
        res = sol.deserialize("[123,[456,[789]]]");
        assertEquals(2, (int) res.getList().size());
    }

}
