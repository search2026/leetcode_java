package com.search2026.leetcode.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPoint {
    @Test
    public void testPointAccess() {
        int x = 4;
        int y = 5;
        Point p = new Point(x, y);
        assertEquals(x, p.x);
        assertEquals(y, p.y);
    }
}
