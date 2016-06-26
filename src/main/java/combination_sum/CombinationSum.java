package combination_sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationSum {
  /*
      Combination Sum - Backtracking
      Leetcode #39
      https://leetcode.com/problems/combination-sum/
      Difficulty: Medium
  */
  public class Solution {
    private void search(int[] cand, List<List<Integer>> comb, List<Integer> currList, int start, int remained) {
      if (remained < 0 || start >= cand.length) return;
      if (remained == 0) {
        comb.add(new ArrayList<Integer>(currList));
        return;
      }

      for (int i = start; i < cand.length && cand[i] <= remained; i++) {
        currList.add(cand[i]);
        search(cand, comb, currList, i, remained - cand[i]);
        currList.remove(currList.size() - 1);
      }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> combo = new ArrayList<>();
      if (candidates == null || candidates.length == 0) return combo;
      Arrays.sort(candidates);
      search(candidates, combo, new ArrayList<Integer>(), 0, target);
      return combo;
    }
  }

  /*
      Combination Sum - Dynamic Programming
      Leetcode #39
      https://leetcode.com/problems/combination-sum/
      Difficulty: Medium
  */
  public class Solution_2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      if (candidates == null || candidates.length == 0)
        return new ArrayList<List<Integer>>();

      Arrays.sort(candidates);
      List<List<List<Integer>>> dp = new ArrayList<>();

      for (int i = 1; i <= target; i++) {
        List<List<Integer>> currList = new ArrayList<>();
        for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
          if (i == candidates[j]) currList.add(Arrays.asList(candidates[j]));
          else {
            for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
              if (candidates[j] <= l.get(0)) {
                List t = new ArrayList<Integer>();
                t.add(candidates[j]);
                t.addAll(l);
                currList.add(t);
              }
            }
          }
        }
        dp.add(currList);
      }
      return dp.get(target - 1);
    }
  }

  /*
      Combination Sum II - Backtracking
      Leetcode #40
      https://leetcode.com/problems/combination-sum-ii/
      Difficulty: Medium
  */
  public class Solution_3 {
    private void search(int[] cand, List<List<Integer>> comb, List<Integer> currList, int start, int remained) {
      if (remained < 0 || start >= cand.length) return;
      if (remained == 0) {
        comb.add(new ArrayList<Integer>(currList));
        return;
      }

      for (int i = start; i < cand.length && cand[i] <= remained; i++) {
        if (i > start && cand[i] == cand[i - 1]) continue;
        currList.add(cand[i]);
        search(cand, comb, currList, i + 1, remained - cand[i]);
        currList.remove(currList.size() - 1);
      }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      List<List<Integer>> comb = new ArrayList<>();
      if (candidates == null || candidates.length == 0) return comb;
      Arrays.sort(candidates);
      search(candidates, comb, new ArrayList<Integer>(), 0, target);
      return comb;
    }
  }

  /*
      Combination Sum II - Dynamic Programming
      Leetcode #40
      https://leetcode.com/problems/combination-sum-ii/
      Difficulty: Medium
  */
  // TODO: To be implemented
  public class Solution_4 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
      if (candidates == null || candidates.length == 0)
        return new ArrayList<List<Integer>>();

      Arrays.sort(candidates);
      List<List<List<Integer>>> dp = new ArrayList<>();

      for (int i = 1; i <= target; i++) {
        List<List<Integer>> currList = new ArrayList<>();
        for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
          if (i == candidates[j]) currList.add(Arrays.asList(candidates[j]));
          else {
            for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
              if (candidates[j] <= l.get(0)) {
                List t = new ArrayList<Integer>();
                t.add(candidates[j]);
                t.addAll(l);
                currList.add(t);
              }
            }
          }
        }
        dp.add(currList);
      }
      return dp.get(target - 1);
    }
  }

  /*
      Combination Sum III - Backtracking
      Leetcode #216
      https://leetcode.com/problems/combination-sum-iii/
      Difficulty: Medium
  */
  public class Solution_5 {
    private void search(List<List<Integer>> combo, List<Integer> currList, int k, int start, int remained) {
      if (remained < 0 || currList.size() > k) return;
      if (remained == 0 && currList.size() == k) {
        combo.add(new ArrayList<>(currList));
        return;
      }

      for (int i = start; i <= 9; i++) {
        if (remained - i < 0) break;
        if (currList.size() > k) break;

        currList.add(i);
        search(combo, currList, k, i + 1, remained - i);
        currList.remove(currList.size() - 1);
      }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> comb = new ArrayList<>();
      search(comb, new ArrayList<Integer>(), k, 1, n);
      return comb;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new CombinationSum().new Solution();
      int[] candidates = new int[]{2, 3, 6, 7};
      List<List<Integer>> comb = sol.combinationSum(candidates, 7);
      assertEquals(2, comb.size());
      assertEquals(3, comb.get(0).size());
      assertEquals(2, (int) comb.get(0).get(0));
      assertEquals(2, (int) comb.get(0).get(1));
      assertEquals(3, (int) comb.get(0).get(2));
      assertEquals(1, comb.get(1).size());
      assertEquals(7, (int) comb.get(1).get(0));
    }

    @Test
    public void test2() {
      Solution_2 sol = new CombinationSum().new Solution_2();
      int[] candidates = new int[]{2, 3, 6, 7};
      List<List<Integer>> comb = sol.combinationSum(candidates, 7);
      assertEquals(2, comb.size());
      assertEquals(3, comb.get(0).size());
      assertEquals(2, (int) comb.get(0).get(0));
      assertEquals(2, (int) comb.get(0).get(1));
      assertEquals(3, (int) comb.get(0).get(2));
      assertEquals(1, comb.get(1).size());
      assertEquals(7, (int) comb.get(1).get(0));
    }

    @Test
    public void test3() {
      Solution_3 sol = new CombinationSum().new Solution_3();
      int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
      List<List<Integer>> comb = sol.combinationSum2(candidates, 8);
      assertEquals(4, comb.size());
      assertEquals(3, comb.get(0).size());
      assertEquals(1, (int) comb.get(0).get(0));
      assertEquals(1, (int) comb.get(0).get(1));
      assertEquals(6, (int) comb.get(0).get(2));
      assertEquals(3, comb.get(1).size());
      assertEquals(1, (int) comb.get(1).get(0));
      assertEquals(2, (int) comb.get(1).get(1));
      assertEquals(5, (int) comb.get(1).get(2));
      assertEquals(2, comb.get(2).size());
      assertEquals(1, (int) comb.get(2).get(0));
      assertEquals(7, (int) comb.get(2).get(1));
      assertEquals(2, comb.get(3).size());
      assertEquals(2, (int) comb.get(3).get(0));
      assertEquals(6, (int) comb.get(3).get(1));
    }

    @Test
    public void test4() {
      Solution_4 sol = new CombinationSum().new Solution_4();
      int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
      List<List<Integer>> combo = sol.combinationSum2(candidates, 8);
      // assertEquals(4, combo.size());
    }

    @Test
    public void test5() {
      Solution_5 sol = new CombinationSum().new Solution_5();
      List<List<Integer>> combo = sol.combinationSum3(3, 7);
      assertEquals(1, combo.size());
      assertEquals(3, combo.get(0).size());
      assertEquals(1, (int)combo.get(0).get(0));
      assertEquals(2, (int)combo.get(0).get(1));
      assertEquals(4, (int)combo.get(0).get(2));

      combo = sol.combinationSum3(3, 9);
      assertEquals(3, combo.size());
      assertEquals(3, combo.get(0).size());
      assertEquals(1, (int)combo.get(0).get(0));
      assertEquals(2, (int)combo.get(0).get(1));
      assertEquals(6, (int)combo.get(0).get(2));
      assertEquals(3, combo.get(1).size());
      assertEquals(1, (int)combo.get(1).get(0));
      assertEquals(3, (int)combo.get(1).get(1));
      assertEquals(5, (int)combo.get(1).get(2));
      assertEquals(3, combo.get(2).size());
      assertEquals(2, (int)combo.get(2).get(0));
      assertEquals(3, (int)combo.get(2).get(1));
      assertEquals(4, (int)combo.get(2).get(2));
    }
  }
}
