package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MergeIntervalsTests {

    @Test
    public void testSolution() {
        MergeIntervals.Solution sol = new MergeIntervals().new Solution();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> rslt = sol.merge(intervals);
        assertEquals(3, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(6, rslt.get(0).end);
        assertEquals(8, rslt.get(1).start);
        assertEquals(10, rslt.get(1).end);
    }

    @Test
    public void testSolution2() {
        MergeIntervals.Solution_2 sol = new MergeIntervals().new Solution_2();
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        List<Interval> rslt = sol.merge(intervals);
        assertEquals(3, rslt.size());
        assertEquals(1, rslt.get(0).start);
        assertEquals(6, rslt.get(0).end);
        assertEquals(8, rslt.get(1).start);
        assertEquals(10, rslt.get(1).end);
    }

}
