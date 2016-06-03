package insert_interval;

import common.Interval;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

            List<Interval> rslt = new ArrayList<Interval>();
            int insertPos = 0;

            for (Interval interval : intervals) {
                if (interval.end < newInterval.start) {
                    rslt.add(interval);
                    insertPos++;
                } else if (interval.start > newInterval.end) {
                    rslt.add(interval);
                } else {
                    newInterval.start = Math.min(interval.start, newInterval.start);
                    newInterval.end = Math.max(interval.end, newInterval.end);
                }
            }

            rslt.add(insertPos, newInterval);

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void testInsert() {
            Solution sol = new InsertInterval().new Solution();
            List<Interval> intervals = new ArrayList<Interval>();
            intervals.add(new Interval(1, 3));
            intervals.add(new Interval(6, 9));
            List<Interval> rslt = sol.insert(intervals, new Interval(2,5));
            assertEquals(1, rslt.get(0).start);
            assertEquals(5, rslt.get(0).end);
        }
    }
}
