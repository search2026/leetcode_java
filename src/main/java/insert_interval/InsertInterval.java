package insert_interval;

import common.Interval;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new InsertInterval().new Solution();
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
        public void test2() {
            Solution_2 sol = new InsertInterval().new Solution_2();
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
}
