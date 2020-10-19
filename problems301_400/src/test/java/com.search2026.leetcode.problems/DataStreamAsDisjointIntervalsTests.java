package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataStreamAsDisjointIntervalsTests {

    @Test
    public void testSolution() {
        DataStreamAsDisjointIntervals.SummaryRanges sr = new DataStreamAsDisjointIntervals().new SummaryRanges();
        sr.addNum(1);
        sr.addNum(3);
        sr.addNum(7);
        sr.addNum(2);
        sr.addNum(6);
        List<Interval> res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(3, res.get(0).end);
        assertEquals(6, res.get(1).start);
        assertEquals(7, res.get(1).end);

        sr.addNum(4);
        res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(4, res.get(0).end);
        assertEquals(6, res.get(1).start);
        assertEquals(7, res.get(1).end);
    }

    @Test
    public void testSolution2() {
        DataStreamAsDisjointIntervals.SummaryRanges_2 sr = new DataStreamAsDisjointIntervals().new SummaryRanges_2();
        sr.addNum(1);
        sr.addNum(3);
        sr.addNum(7);
        sr.addNum(2);
        sr.addNum(6);
        List<Interval> res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(3, res.get(0).end);
        assertEquals(6, res.get(1).start);
        assertEquals(7, res.get(1).end);

        sr.addNum(5);
        res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(3, res.get(0).end);
        assertEquals(5, res.get(1).start);
        assertEquals(7, res.get(1).end);
    }

    @Test
    public void testSolution3() {
        DataStreamAsDisjointIntervals.SummaryRanges_3 sr = new DataStreamAsDisjointIntervals().new SummaryRanges_3();
        sr.addNum(1);
        sr.addNum(3);
        sr.addNum(7);
        sr.addNum(2);
        sr.addNum(6);
        List<Interval> res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(3, res.get(0).end);
        assertEquals(6, res.get(1).start);
        assertEquals(7, res.get(1).end);

        sr.addNum(5);
        res = sr.getIntervals();
        assertEquals(2, res.size());
        assertEquals(1, res.get(0).start);
        assertEquals(3, res.get(0).end);
        assertEquals(5, res.get(1).start);
        assertEquals(7, res.get(1).end);
    }

}
