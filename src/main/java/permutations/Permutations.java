package permutations;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Permutations {
  /*
      Permutations - Backtracking
      Leetcode #46
      https://leetcode.com/problems/permutations/
      Difficulty: Medium
  */
  public class Solution {
    private void search(int[] nums, List<List<Integer>> permList, List<Integer> curr, boolean[] visited, int level, int n) {
      if (level == n) {
        permList.add(new ArrayList(curr));
      }

      for (int i = 0; i < n; i++) {
        if (!visited[i]) {
          curr.add(nums[i]);
          visited[i] = true;
          search(nums, permList, curr, visited, level + 1, n);
          visited[i] = false;
          curr.remove(curr.size() - 1);
        }
      }
    }

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> permList = new ArrayList<>();
      if (nums == null || nums.length == 0) return permList;

      int n = nums.length;
      boolean[] visited = new boolean[n];
      List<Integer> curr = new ArrayList<Integer>();
      search(nums, permList, curr, visited, 1, n);

      return permList;
    }
  }

  /*
      Permutations - Iterative
      Leetcode #46
      https://leetcode.com/problems/permutations/
      Difficulty: Medium
  */
  public class Solution_2 {
    public List<List<Integer>> permute(int[] nums) {
      LinkedList<List<Integer>> permList = new LinkedList<>();
      if (nums == null || nums.length == 0) return permList;
      permList.add(new ArrayList<Integer>());
      for (int n : nums) {
        int size = permList.size();
        for (; size > 0; size--) {
          List<Integer> r = permList.pollFirst();
          for (int i = 0; i <= r.size(); i++) {
            List<Integer> t = new ArrayList<>(r);
            t.add(i, n);
            permList.add(t);
          }
        }
      }
      return permList;
    }
  }

  /*
      Permutations - Insert
      Leetcode #46
      https://leetcode.com/problems/permutations/
      Difficulty: Medium
  */
  public class Solution_3 {
    private List<List<Integer>> insert(List<List<Integer>> list, int num) {
      List<List<Integer>> rslt = new ArrayList<List<Integer>>();
      for (int i = 0; i < list.size(); i++) {
        for (int j = 0; j < list.get(i).size() + 1; j++) {
          ArrayList<Integer> curr = new ArrayList<Integer>(list.get(i));
          curr.add(j, num);
          rslt.add(curr);
        }
      }
      return rslt;
    }

    public List<List<Integer>> permute(int[] num) {
      List<List<Integer>> permList = new ArrayList<List<Integer>>();
      List<Integer> curr = new ArrayList<>();
      curr.add(num[0]);
      permList.add(curr);
      for (int i = 1; i < num.length; i++) {
        permList = insert(permList, num[i]);
      }
      return permList;
    }
  }

  /*
    Permutations - Insert
    Leetcode #46
    https://leetcode.com/problems/permutations/
    Difficulty: Medium
*/
  public class Solution_4 {
    public List<List<Integer>> permute(int[] num) {
      List<List<Integer>> permList = new ArrayList<>();
      if (num.length == 0) return permList;
      List<Integer> curr = new ArrayList<>();
      curr.add(num[0]);
      permList.add(curr);
      for (int i = 1; i < num.length; ++i) {
        List<List<Integer>> currPerm = new ArrayList<>();
        for (int j = 0; j <= i; ++j) {
          for (List<Integer> l : permList) {
            List<Integer> currList = new ArrayList<>(l);
            currList.add(j, num[i]);
            currPerm.add(currList);
          }
        }
        permList = currPerm;
      }
      return permList;
    }
  }

  /*
      Permutations II
      Leetcode #47
      https://leetcode.com/problems/permutations-ii/
      Difficulty: Medium
  */
  public class Solution_5 {
    private List<List<Integer>> permuteUnique(int[] nums) {
      Arrays.sort(nums);
      List<Integer> cur = new ArrayList<Integer>();
      List<List<Integer>> rslt = new ArrayList<List<Integer>>();
      boolean[] visited = new boolean[nums.length];

      permute(nums, visited, cur, rslt);
      return rslt;
    }

    public void permute(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> rslt) {
      if (cur.size() == nums.length) {
        rslt.add(new ArrayList<Integer>(cur));
        return;
      }

      for (int k = 0; k < nums.length; k++) {
        if (k > 0 && !visited[k - 1] && nums[k] == nums[k - 1]) continue;
        if (!visited[k]) {
          visited[k] = true;
          cur.add(nums[k]);
          permute(nums, visited, cur, rslt);
          cur.remove(cur.size() - 1);
          visited[k] = false;
        }
      }
    }
  }

  public class UnitTest {
    @Test
    public void test1() {
      Solution sol = new Permutations().new Solution();
      int[] test = {1, 2, 3};
      List<List<Integer>> rslt = sol.permute(test);
      assertEquals(6, rslt.size());
      assertEquals(test.length, rslt.get(0).size());
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
      assertEquals(3, (int) rslt.get(0).get(2));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(2, (int) rslt.get(rslt.size() - 1).get(1));
      assertEquals(1, (int) rslt.get(rslt.size() - 1).get(2));
    }

    @Test
    public void test2() {
      Solution_2 sol = new Permutations().new Solution_2();
      int[] test = {1, 2, 3};
      List<List<Integer>> rslt = sol.permute(test);
      assertEquals(6, rslt.size());
      assertEquals(test.length, rslt.get(0).size());
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
      assertEquals(3, (int) rslt.get(0).get(2));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(2, (int) rslt.get(rslt.size() - 1).get(1));
      assertEquals(1, (int) rslt.get(rslt.size() - 1).get(2));
    }

    @Test
    public void test3() {
      Solution_3 sol = new Permutations().new Solution_3();
      int[] test = {1, 2, 3};
      List<List<Integer>> rslt = sol.permute(test);
      assertEquals(6, rslt.size());
      assertEquals(test.length, rslt.get(0).size());
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
      assertEquals(3, (int) rslt.get(0).get(2));
      assertEquals(3, (int) rslt.get(rslt.size() - 1).get(0));
      assertEquals(2, (int) rslt.get(rslt.size() - 1).get(1));
      assertEquals(1, (int) rslt.get(rslt.size() - 1).get(2));
    }
  }
}
