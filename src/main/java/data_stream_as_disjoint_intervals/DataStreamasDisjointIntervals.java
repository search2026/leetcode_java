package data_stream_as_disjoint_intervals;

import common.Interval;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class DataStreamasDisjointIntervals {
  /*
      Data Stream as Disjoint Intervals - Insert Intervals
      Leetcode #352
      https://leetcode.com/problems/data-stream-as-disjoint-intervals/
      Difficulty: Hard
   */
  public class SummaryRanges {
    List<Interval> intervals;

    public SummaryRanges() {
      intervals = new ArrayList<>();
    }

    public void addNum(int val) {
      int start = 0;
      List<Interval> list = new ArrayList<>();
      Interval newItem = new Interval(val, val);
      for (int i = 0; i < intervals.size(); i++) {
        Interval curr = intervals.get(i);
        if (curr.end + 1 < newItem.start) {
          list.add(curr);
        } else if (curr.start - 1 > newItem.end) {
          list.add(newItem);
          newItem = curr;
        } else {
          newItem.start = Math.min(newItem.start, curr.start);
          newItem.end = Math.max(newItem.end, curr.end);
        }
      }
      list.add(newItem);
      intervals = list;
    }

    public List<Interval> getIntervals() {
      return intervals;
    }
  }

  /*
      Data Stream as Disjoint Intervals - Treemap
      Leetcode #352
      https://leetcode.com/problems/data-stream-as-disjoint-intervals/
      Difficulty: Hard
   */
  public class SummaryRanges_2 {
    TreeMap<Integer, Interval> tree;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges_2() {
      tree = new TreeMap<>();
    }

    public void addNum(int val) {
      if (tree.containsKey(val)) return;
      Integer low = tree.lowerKey(val);
      Integer high = tree.higherKey(val);
      if (low != null && high != null && tree.get(low).end + 1 == val && high == val + 1) {
        tree.get(low).end = tree.get(high).end;
        tree.remove(high);
      } else if (low != null && tree.get(low).end + 1 >= val) {
        tree.get(low).end = Math.max(tree.get(low).end, val);
      } else if (high != null && high == val + 1) {
        tree.put(val, new Interval(val, tree.get(high).end));
        tree.remove(high);
      } else {
        tree.put(val, new Interval(val, val));
      }
    }

    public List<Interval> getIntervals() {
      return new ArrayList<>(tree.values());
    }
  }

  /*
    Data Stream as Disjoint Intervals - Union Find
    Leetcode #352
    https://leetcode.com/problems/data-stream-as-disjoint-intervals/
    Difficulty: Hard
 */
  public class SummaryRanges_3 {
    Map<Integer, Integer> map;
    Map<Integer, Integer> Intervals;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges_3() {
      map = new HashMap<>();
      Intervals = new HashMap<>();
    }

    public void addNum(int val) {
      if (map.containsKey(val))
        return;
      else {
        map.put(val, 1);
        if (map.containsKey(val + 1) && map.containsKey(val - 1)) {
          int l = map.get(val + 1);
          int r = map.get(val - 1);
          map.put(val + l, l + r + 1);
          map.put(val - r, l + r + 1);
          Intervals.remove(val + 1);
          Intervals.put(val - r, l + r + 1);
        } else if (map.containsKey(val + 1)) {
          int l = map.get(val + 1);
          map.put(val + l, l + 1);
          map.put(val, l + 1);
          Intervals.remove(val + 1);
          Intervals.put(val, l + 1);
        } else if (map.containsKey(val - 1)) {
          int r = map.get(val - 1);
          map.put(val - r, r + 1);
          map.put(val, r + 1);
          Intervals.put(val - r, r + 1);
        } else
          Intervals.put(val, 1);
      }
    }

    public List<Interval> getIntervals() {
      List<Interval> list = new ArrayList<>();
      for (Integer i : Intervals.keySet())
        list.add(new Interval(i, i + Intervals.get(i) - 1));
      Collections.sort(list, new Comparator<Interval>() {
        @Override
        public int compare(Interval i1, Interval i2) {
          return i1.start - i2.start;
        }
      });
      return list;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      SummaryRanges sr = new DataStreamasDisjointIntervals().new SummaryRanges();
      sr.addNum(1);
      sr.addNum(3);
      sr.addNum(7);
      sr.addNum(2);
      sr.addNum(6);
      List<Interval> rslt = sr.getIntervals();
      assertEquals(2, rslt.size());
      assertEquals(1, rslt.get(0).start);
      assertEquals(3, rslt.get(0).end);
      assertEquals(6, rslt.get(1).start);
      assertEquals(7, rslt.get(1).end);

      sr.addNum(4);
      rslt = sr.getIntervals();
      assertEquals(2, rslt.size());
      assertEquals(1, rslt.get(0).start);
      assertEquals(4, rslt.get(0).end);
      assertEquals(6, rslt.get(1).start);
      assertEquals(7, rslt.get(1).end);
    }

    @Test
    public void test2() {
      SummaryRanges_2 sr = new DataStreamasDisjointIntervals().new SummaryRanges_2();
      sr.addNum(1);
      sr.addNum(3);
      sr.addNum(7);
      sr.addNum(2);
      sr.addNum(6);
      List<Interval> rslt = sr.getIntervals();
      assertEquals(2, rslt.size());
      assertEquals(1, rslt.get(0).start);
      assertEquals(3, rslt.get(0).end);
      assertEquals(6, rslt.get(1).start);
      assertEquals(7, rslt.get(1).end);

      sr.addNum(5);
      rslt = sr.getIntervals();
      assertEquals(2, rslt.size());
      assertEquals(1, rslt.get(0).start);
      assertEquals(3, rslt.get(0).end);
      assertEquals(5, rslt.get(1).start);
      assertEquals(7, rslt.get(1).end);
    }
  }
}

