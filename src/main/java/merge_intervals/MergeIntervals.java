package merge_intervals;

import common.Interval;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

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

      List<Interval> intervalList = new ArrayList<>();
      Interval last = intervals.get(0);
      for (int i = 1; i < intervals.size(); i++) {
        Interval cur = intervals.get(i);
        if (cur.start <= last.end) {
          last.end = Math.max(last.end, cur.end);
        } else {
          intervalList.add(last);
          last = cur;
        }
      }

      intervalList.add(last);
      return intervalList;
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

      Collections.sort(intervals, (Interval i1, Interval i2) -> (i1.start - i2.start));

      ListIterator<Interval> it = intervals.listIterator();
      Interval cur = it.next();
      while (it.hasNext()) {
        Interval next = it.next();
        if (cur.end < next.start) {
          cur = next;
        } else {
          cur.end = Math.max(cur.end, next.end);
          it.remove();
        }
      }
      return intervals;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MergeIntervals().new Solution();
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
    public void test2() {
      Solution_2 sol = new MergeIntervals().new Solution_2();
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
}
