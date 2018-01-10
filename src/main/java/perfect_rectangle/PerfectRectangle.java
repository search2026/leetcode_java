package perfect_rectangle;

import common.Interval;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class PerfectRectangle {
  /*
      Perfect Rectangle
      Leetcode #391
      https://leetcode.com/problems/perfect-rectangle/
      Difficulty: Hard
   */
  public class Solution {
    private List<Interval> merge(List<Interval> intervals) {
      List<Interval> res = new ArrayList<>();
      if (intervals == null || intervals.size() < 2) return intervals;
      Collections.sort(intervals, new Comparator<Interval>() {
        public int compare(Interval i1, Interval i2) {
          return i1.start - i2.start;
        }
      });
      int start = intervals.get(0).start, end = intervals.get(0).end;
      for (int i = 1; i < intervals.size(); i++) {
        Interval cur = intervals.get(i);
        if (cur.start > end) {
          res.add(new Interval(start, end));
          start = cur.start;
        }
        if (cur.end > end) end = cur.end;
      }
      res.add(new Interval(start, end));
      return res;
    }

    private boolean compareMaps(HashMap<Integer, ArrayList<Interval>> map1, HashMap<Integer, ArrayList<Interval>> map2, int side) {
      for (int top : map1.keySet()) {
        if (top == side) continue;
        List<Interval> mergedTopList = merge(map1.get(top));
        if (!map2.containsKey(top)) return false;
        List<Interval> mergedBottomeList = merge(map2.get(top));
        if (mergedBottomeList.size() != mergedTopList.size()) return false;
        for (int i = 0; i < mergedBottomeList.size(); i++) {
          if (mergedBottomeList.get(i).start != mergedTopList.get(i).start || mergedBottomeList.get(i).end != mergedTopList.get(i).end)
            return false;
        }
      }
      return true;
    }

    public boolean isRectangleCover(int[][] rectangles) {
      long area = 0;
      int up = Integer.MIN_VALUE, low = Integer.MAX_VALUE, rightest = Integer.MIN_VALUE, leftest = Integer.MAX_VALUE;
      HashMap<Integer, ArrayList<Interval>> topmap = new HashMap<>();
      HashMap<Integer, ArrayList<Interval>> bottommap = new HashMap<>();
      HashMap<Integer, ArrayList<Interval>> leftmap = new HashMap<>();
      HashMap<Integer, ArrayList<Interval>> rightmap = new HashMap<>();
      for (int i = 0; i < rectangles.length; i++) {
        int[] r1 = rectangles[i];
        int top = r1[3], right = r1[2], left = r1[0], bottom = r1[1];
        up = Math.max(top, up);
        low = Math.min(low, bottom);
        rightest = Math.max(right, rightest);
        leftest = Math.min(left, leftest);
        if (!topmap.containsKey(top)) topmap.put(top, new ArrayList<Interval>());
        topmap.get(top).add(new Interval(left, right));
        if (!bottommap.containsKey(bottom)) bottommap.put(bottom, new ArrayList<Interval>());
        bottommap.get(bottom).add(new Interval(left, right));
        if (!leftmap.containsKey(left)) leftmap.put(left, new ArrayList<Interval>());
        leftmap.get(left).add(new Interval(bottom, top));
        if (!rightmap.containsKey(right)) rightmap.put(right, new ArrayList<Interval>());
        rightmap.get(right).add(new Interval(bottom, top));
        area += (top - bottom) * (right - left);
      }
      if (area != (rightest - leftest) * (up - low)) return false;
      if (bottommap.size() != topmap.size() || leftmap.size() != rightmap.size()) return false;
      return (compareMaps(bottommap, topmap, low) && compareMaps(rightmap, leftmap, rightest));
    }

  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new PerfectRectangle().new Solution();
      int[][] rectangles = {
              {1, 1, 3, 3},
              {3, 1, 4, 2},
              {3, 2, 4, 4},
              {1, 3, 2, 4},
              {2, 3, 3, 4}
      };
      assertTrue(sol.isRectangleCover(rectangles));

      rectangles = new int[][]{
              {1, 1, 2, 3},
              {1, 3, 2, 4},
              {3, 1, 4, 2},
              {3, 2, 4, 4}
      };
      assertFalse(sol.isRectangleCover(rectangles));

      rectangles = new int[][]{
              {1, 1, 3, 3},
              {3, 1, 4, 2},
              {1, 3, 2, 4},
              {3, 2, 4, 4}
      };
      assertFalse(sol.isRectangleCover(rectangles));

      rectangles = new int[][]{
              {1, 1, 3, 3},
              {3, 1, 4, 2},
              {1, 3, 2, 4},
              {2, 2, 4, 4}
      };
      assertFalse(sol.isRectangleCover(rectangles));
    }
  }
}

