package combination_sum;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // Combination Sum
    // https://leetcode.com/problems/combination-sum/
    // Difficulty: Medium
    public class Solution {
        private void search(int[] n, int index, int target,
                            ArrayDeque<Integer> s, List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<Integer>(s));
                return;
            }
            if (index == n.length || target < n[index]) {
                return;
            }

            for (int i = 0; i <= target / n[index]; i++) {
                search(n, index + 1, target - i * n[index], s, ans);
                s.offerLast(n[index]);
            }
            for (int i = 0; i <= target / n[index]; i++) {
                s.removeLast();
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates,
                                                  int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            Arrays.sort(candidates);
            search(candidates, 0, target, new ArrayDeque<Integer>(), ans);
            return ans;
        }
    }

    // Combination Sum II
    // https://leetcode.com/problems/combination-sum-ii/
    // Difficulty: Medium
    public class SolutionII {
        private void search(List<Integer> nums, List<Integer> counts,
                            int index, int target, ArrayDeque<Integer> s,
                            List<List<Integer>> ans) {
            if (target == 0) {
                ans.add(new ArrayList<Integer>(s));
            }
            if (target <= 0 || index == nums.size()) {
                return;
            }
            int n = nums.get(index);
            int count = counts.get(index);
            for (int i = 0; i <= count; i++) {
                search(nums, counts, index + 1, target - i * n, s, ans);
                s.offerLast(n);
            }
            for (int i = 0; i <= count; i++) {
                s.removeLast();
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates,
                                                   int target) {
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            if (candidates.length == 0) {
                return ans;
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
            search(nums, counts, 0, target, new ArrayDeque<Integer>(), ans);
            return ans;
        }
    }

    // Combination Sum III
    // https://leetcode.com/problems/combination-sum-iii/
    // Difficulty: Medium
    public class SolutionIII {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            List<Integer> list = new ArrayList<Integer>();
            dfs(result, 1, n, list, k);
            return result;
        }

        public void dfs(List<List<Integer>> result, int start, int sum, List<Integer> list, int k) {
            if (sum == 0 && list.size() == k) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(list);
                result.add(temp);
            }

            for (int i = start; i <= 9; i++) {
                if (sum - i < 0) break;
                if (list.size() > k) break;

                list.add(i);
                dfs(result, i + 1, sum - i, list, k);
                list.remove(list.size() - 1);
            }
        }
    }

    public static class UnitTest {

    }
}
