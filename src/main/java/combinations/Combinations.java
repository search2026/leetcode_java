package combinations;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Combinations {
  /*
      Combinations - Backtracking
      Leetcode #77
      https://leetcode.com/problems/combinations/
      Difficulty: Medium
   */
  public class Solution {
    private void search(List<List<Integer>> rslt, List<Integer> curr, int start, int end, int k) {
      if (k == 0) {
        rslt.add(new ArrayList<Integer>(curr));
        return;
      }

      for (int i = start; i <= end - k + 1; i++) {
        curr.add(i);
        search(rslt, curr, i + 1, end, k - 1);
        curr.remove(curr.size() - 1);
      }
    }

    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> combList = new ArrayList<>();
      if (n < 1 || k < 1 || n < k) return combList;

      search(combList, new ArrayList<Integer>(), 1, n, k);

      return combList;
    }
  }

  /*
      Combinations - Iterative
      Leetcode #77
      https://leetcode.com/problems/combinations/
      Difficulty: Medium
   */
  public class Solution_2 {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> combList = new ArrayList<>();
      if (n < 1 || k < 1 || n < k) return combList;
      for (int i = 1; i <= n; i++) combList.add(Arrays.asList(i));
      for (int i = 2; i <= k; i++) {
        List<List<Integer>> newCombs = new ArrayList<>();
        for (int j = i; j <= n; j++) {
          for (List<Integer> comb : combList) {
            if (comb.get(comb.size() - 1) < j) {
              List<Integer> newComb = new ArrayList<>(comb);
              newComb.add(j);
              newCombs.add(newComb);
            }
          }
        }
        combList = newCombs;
      }
      return combList;
    }
  }

  /*
      Combinations - Iterative
      Leetcode #77
      https://leetcode.com/problems/combinations/
      Difficulty: Medium
   */
  public class Solution_3 {
    public List<List<Integer>> combine(int n, int k) {
      List<List<Integer>> combList = new ArrayList<>();
      if (n < 1 || k < 1 || n < k) return combList;
      List<Integer> curr = new ArrayList<>();
      int i = 1;
      while (i <= n || curr.size() != 0) {
        if (curr.size() == k) combList.add(new ArrayList(curr));

        if (i > n || curr.size() == k) {
          i = curr.get(curr.size() - 1) + 1;
          curr.remove(curr.size() - 1);
        } else {
          curr.add(i);
          i++;
        }
      }
      return combList;
    }
  }

  /*
      Combinations - Dynamic Programming
      Leetcode #77
      https://leetcode.com/problems/combinations/
      Difficulty: Medium
   */
  public class Solution_4 {
    public List<List<Integer>> combine(int n, int k) {
      if (k == n || k == 0) {
        List<Integer> row = new LinkedList<>();
        for (int i = 1; i <= k; ++i) row.add(i);
        return new LinkedList<>(Arrays.asList(row));
      }

      List<List<Integer>> combList = this.combine(n - 1, k - 1);
      combList.forEach(e -> e.add(n));
      combList.addAll(this.combine(n - 1, k));
      return combList;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new Combinations().new Solution();
      List<List<Integer>> rslt = sol.combine(4, 2);
      assertEquals(6, rslt.size());
      assertEquals(2, rslt.get(0).size());
      Collections.sort(rslt, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          if (o1.get(0).equals(o2.get(0)))
            return o1.get(1) - o2.get(1);
          return o1.get(0) - o2.get(0);
        }
      });
      assertEquals(1, (int) rslt.get(0).get(0));
      assertEquals(2, (int) rslt.get(0).get(1));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(4, (int) rslt.get(rslt.size() - 1).get(1));
    }

    @Test
    public void test2() {
      Solution_2 sol = new Combinations().new Solution_2();
      List<List<Integer>> rslt = sol.combine(4, 2);
      assertEquals(6, rslt.size());
      assertEquals(2, rslt.get(0).size());
      Collections.sort(rslt, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          if (o1.get(0).equals(o2.get(0)))
            return o1.get(1) - o2.get(1);
          return o1.get(0) - o2.get(0);
        }
      });
      assertEquals(1, (int) rslt.get(0).get(0));
      assertEquals(2, (int) rslt.get(0).get(1));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(4, (int) rslt.get(rslt.size() - 1).get(1));
    }

    @Test
    public void test3() {
      Solution_3 sol = new Combinations().new Solution_3();
      List<List<Integer>> rslt = sol.combine(4, 2);
      assertEquals(6, rslt.size());
      assertEquals(2, rslt.get(0).size());
      Collections.sort(rslt, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          if (o1.get(0).equals(o2.get(0)))
            return o1.get(1) - o2.get(1);
          return o1.get(0) - o2.get(0);
        }
      });
      assertEquals(1, (int) rslt.get(0).get(0));
      assertEquals(2, (int) rslt.get(0).get(1));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(4, (int) rslt.get(rslt.size() - 1).get(1));
    }

    @Test
    public void test4() {
      Solution_4 sol = new Combinations().new Solution_4();
      List<List<Integer>> rslt = sol.combine(4, 2);
      assertEquals(6, rslt.size());
      assertEquals(2, rslt.get(0).size());
      Collections.sort(rslt, new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
          if (o1.get(0).equals(o2.get(0)))
            return o1.get(1) - o2.get(1);
          return o1.get(0) - o2.get(0);
        }
      });
      assertEquals(1, (int) rslt.get(0).get(0));
      assertEquals(2, (int) rslt.get(0).get(1));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(4, (int) rslt.get(rslt.size() - 1).get(1));
    }
  }
}
