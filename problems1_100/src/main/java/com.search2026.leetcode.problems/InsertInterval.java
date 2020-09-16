package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    /*
        Insert Interval
        Leetcode #57
        https://leetcode.com/problems/insert-interval/
        Difficulty: Hard
     */
    public class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            if (newInterval == null || intervals == null) return intervals;

            List<Interval> intervalList = new ArrayList<>();
            int pos = 0;

            for (Interval interval : intervals) {
                if (interval.end < newInterval.start) {
                    intervalList.add(interval);
                    pos++;
                } else if (interval.start > newInterval.end) {
                    intervalList.add(interval);
                } else {
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    newInterval.end = Math.max(interval.end, newInterval.end);
                }
            }

            intervalList.add(pos, newInterval);

            return intervalList;
        }
    }

    /*
        Insert Interval - Using existed list
        Leetcode #57
        https://leetcode.com/problems/insert-interval/
        Difficulty: Hard
     */
    public class Solution_2 {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            if (newInterval == null || intervals == null) return intervals;

            int pos = 0;
            while (pos < intervals.size() && intervals.get(pos).end < newInterval.start) pos++;
            while (pos < intervals.size() && intervals.get(pos).start <= newInterval.end) {
                newInterval.start = Math.min(intervals.get(pos).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(pos).end, newInterval.end);
                intervals.remove(pos);
            }
            intervals.add(pos, newInterval);

            return intervals;
        }
    }

}
