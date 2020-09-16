package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;

import java.util.*;

public class MergeIntervals {

    /*
        Merge Intervals
        Leetcode #56
        https://leetcode.com/problems/merge-intervals/
        Difficulty: Hard
     */
    public class Solution {
        private class IntervalComparator implements Comparator<Interval> {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        }

        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.size() == 0) return intervals;

            Collections.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));

            List<Interval> res = new ArrayList<>();
            Interval prev = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (cur.start <= prev.end) {
                    prev.end = Math.max(prev.end, cur.end);
                } else {
                    res.add(prev);
                    prev = cur;
                }
            }

            res.add(prev);
            return res;
        }
    }

    /*
        Merge Intervals - Using existed list
        Leetcode #56
        https://leetcode.com/problems/merge-intervals/
        Difficulty: Hard
     */
    public class Solution_2 {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals == null || intervals.size() == 0) return intervals;

            intervals.sort((Interval i1, Interval i2) -> (i1.start - i2.start));

            ListIterator<Interval> it = intervals.listIterator();
            Interval prev = it.next();
            while (it.hasNext()) {
                Interval curr = it.next();
                if (curr.start <= prev.end) {
                    prev.end = Math.max(prev.end, curr.end);
                    it.remove();
                } else {
                    prev = curr;
                }
            }
            return intervals;
        }
    }

}
