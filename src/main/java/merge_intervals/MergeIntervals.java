package merge_intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import common.Interval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeIntervals {
    /*
        Merge Intervals
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
            if (intervals == null || intervals.size() <= 1) return intervals;

            Collections.sort(intervals, new IntervalComparator());

            List<Interval> rslt = new ArrayList<Interval>();
            Interval last = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                Interval cur = intervals.get(i);
                if (cur.start <= last.end ){
                    last.end = Math.max(last.end, cur.end);
                }else{
                    rslt.add(last);
                    last = cur;
                }
            }

            rslt.add(last);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void testInsert() {
            Solution sol = new MergeIntervals().new Solution();
            List<Interval> intervals = new ArrayList<Interval>();
            intervals.add(new Interval(1, 3));
            intervals.add(new Interval(2, 6));
            intervals.add(new Interval(8, 10));
            intervals.add(new Interval(15, 18));
            List<Interval> rslt = sol.merge(intervals);
            assertEquals(1, rslt.get(0).start);
            assertEquals(6, rslt.get(0).end);
            assertEquals(8, rslt.get(1).start);
            assertEquals(10, rslt.get(1).end);        }
    }
}
