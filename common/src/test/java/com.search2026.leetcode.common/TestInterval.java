package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInterval {

    @Test
    public void testIntervalAccess() {
        Interval a = new Interval(3, 5);
        assertEquals(3, a.start);
        assertEquals(5, a.end);

        Interval b = new Interval(3, 10);
        Interval c = new Interval(3, 5);
        assertNotEquals(a, b);
        assertEquals(a, c);
    }

}
