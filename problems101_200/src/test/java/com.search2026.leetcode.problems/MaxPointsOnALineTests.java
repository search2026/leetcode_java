package com.search2026.leetcode.problems;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPointsOnALineTests {

    @Test
    public void test1() {
        MaxPointsOnALine.Solution sol = new MaxPointsOnALine().new Solution();
        Point[] points = new Point[1];
        points[0] = new Point(0, 0);
        assertEquals(1, sol.maxPoints(points));

        points = new Point[2];
        points[0] = new Point(0, 0);
        points[1] = new Point(0, 0);
        assertEquals(2, sol.maxPoints(points));

        points = new Point[6];
        points[0] = new Point(0, 0);
        points[1] = new Point(1, 1);
        points[2] = new Point(-1, -1);
        points[3] = new Point(-1, 0);
        points[4] = new Point(-5, 2);
        points[5] = new Point(-1, -1);
        assertEquals(4, sol.maxPoints(points));
    }

}
