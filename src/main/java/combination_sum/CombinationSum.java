package combination_sum;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CombinationSum {
    /*
        Combination Sum
        https://leetcode.com/problems/combination-sum/
        Difficulty: Medium
    */
    public class Solution {
        public void search(List<List<Integer>> rslt, List<Integer> item, int[] candidates, int remained, int start) {
            if (remained < 0) return;
            if (remained == 0) {
                rslt.add(new ArrayList<Integer>(item));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                item.add(candidates[i]);
                search(rslt, item, candidates, remained - candidates[i], i);
                item.remove(item.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            Arrays.sort(candidates);
            search(rslt, new ArrayList<Integer>(), candidates, target, 0);
            return rslt;
        }
    }

    /*
        Combination Sum - From Least Weight Item to Most Weight
        https://leetcode.com/problems/combination-sum/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            Arrays.sort(candidates);
            search(candidates, 0, target, new ArrayList<Integer>(), rslt);
            return rslt;
        }

        private void search(int[] n, int index, int target, List<Integer> cur, List<List<Integer>> rslt) {
            if (target == 0) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }
            if (index == n.length || target < n[index]) {
                return;
            }

            for (int i = 0; i <= target / n[index]; i++) {
                search(n, index + 1, target - i * n[index], cur, rslt);
                cur.add(n[index]);
            }
            for (int i = 0; i <= target / n[index]; i++) {
                cur.remove(cur.size() - 1);
            }
        }
    }

    /*
        Combination Sum II - From Least Weight Item to Most Weight
        https://leetcode.com/problems/combination-sum-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private void search(int[] num, int start, int target, List<Integer> cur, List<List<Integer>> rslt) {
            if (target == 0) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }
            if (target < 0 || start >= num.length)
                return;
            for (int i = start; i < num.length; i++) {
                if (i > start && num[i] == num[i - 1]) continue;
                cur.add(num[i]);
                search(num, i + 1, target - num[i], cur, rslt);
                cur.remove(cur.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum2(int[] nums, int target) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0)
                return rslt;
            Arrays.sort(nums);
            search(nums, 0, target, new ArrayList<Integer>(), rslt);
            return rslt;
        }
    }

    /*
        Combination Sum II - From Least Weight Item to Most Weight
        https://leetcode.com/problems/combination-sum-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        private void search(List<Integer> nums, List<Integer> counts, int index, int target, List<Integer> cur, List<List<Integer>> rslt) {
            if (target == 0) {
                rslt.add(new ArrayList<Integer>(cur));
            }
            if (target <= 0 || index == nums.size()) {
                return;
            }
            int n = nums.get(index);
            int count = counts.get(index);
            for (int i = 0; i <= count; i++) {
                search(nums, counts, index + 1, target - i * n, cur, rslt);
                cur.add(n);
            }
            for (int i = 0; i <= count; i++) {
                cur.remove(cur.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            if (candidates.length == 0) {
                return rslt;
            }
            Arrays.sort(candidates);
            List<Integer> nums = new ArrayList<Integer>();
            List<Integer> counts = new ArrayList<Integer>();
            int count = 1;
            int i = 1;
            for (; i < candidates.length; i++) {
                if (candidates[i] != candidates[i - 1]) {
                    nums.add(candidates[i - 1]);
                    counts.add(count);
                    count = 1;
                } else {
                    count++;
                }

            }
            nums.add(candidates[i - 1]);
            counts.add(count);
            search(nums, counts, 0, target, new ArrayList<Integer>(), rslt);
            return rslt;
        }
    }

    /*
        Combination Sum III
        https://leetcode.com/problems/combination-sum-iii/
        Difficulty: Medium
    */
    public class Solution_5 {
        public void search(List<List<Integer>> rslt, int start, int sum, List<Integer> cur, int k) {
            if (sum == 0 && cur.size() == k) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(cur);
                rslt.add(temp);
            }

            for (int i = start; i <= 9; i++) {
                if (sum - i < 0) break;
                if (cur.size() > k) break;

                cur.add(i);
                search(rslt, i + 1, sum - i, cur, k);
                cur.remove(cur.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            search(rslt, 1, n, new ArrayList<Integer>(), k);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            //Solution sol = new CombinationSum().new Solution();
            Solution_2 sol = new CombinationSum().new Solution_2();
            int[] candidates = new int[]{2, 3, 6, 7};
            List<List<Integer>> rslt = sol.combinationSum(candidates, 7);
            assertEquals(2, rslt.size());
        }

        @Test
        public void test2() {
            //Solution_3 sol = new CombinationSum().new Solution_3();
            Solution_4 sol = new CombinationSum().new Solution_4();
            int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
            List<List<Integer>> rslt = sol.combinationSum2(candidates, 8);
            assertEquals(4, rslt.size());
        }

        @Test
        public void test3() {
            Solution_5 sol = new CombinationSum().new Solution_5();
            List<List<Integer>> rslt = sol.combinationSum3(3, 9);
            assertEquals(3, rslt.size());
        }
    }
}
