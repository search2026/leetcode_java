package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InsertIntervalTests {

    @Test
    public void testSolution() {
        InsertInterval.Solution sol = new InsertInterval().new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        List<Interval> rslt = sol.insert(intervals, new Interval(2, 5));
        assertEquals(2, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(5, rslt.get(0).end);
        assertEquals(6, rslt.get(1).start);
        assertEquals(9, rslt.get(1).end);

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        rslt = sol.insert(intervals, new Interval(4, 9));
        assertEquals(3, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(2, rslt.get(0).end);
        assertEquals(3, rslt.get(1).start);
        assertEquals(10, rslt.get(1).end);
        assertEquals(12, rslt.get(2).start);
        assertEquals(16, rslt.get(2).end);
    }

    @Test
    public void testSolution2() {
        InsertInterval.Solution_2 sol = new InsertInterval().new Solution_2();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));
        List<Interval> rslt = sol.insert(intervals, new Interval(2, 5));
        assertEquals(2, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(5, rslt.get(0).end);
        assertEquals(6, rslt.get(1).start);
        assertEquals(9, rslt.get(1).end);

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 2));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(12, 16));
        rslt = sol.insert(intervals, new Interval(4, 9));
        assertEquals(3, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(2, rslt.get(0).end);
        assertEquals(3, rslt.get(1).start);
        assertEquals(10, rslt.get(1).end);
        assertEquals(12, rslt.get(2).start);
        assertEquals(16, rslt.get(2).end);
    }

}
