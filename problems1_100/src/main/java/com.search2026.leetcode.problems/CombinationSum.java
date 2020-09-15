package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

    /*
        Combination Sum - Backtracking
        Leetcode #39
        https://leetcode.com/problems/combination-sum/
        Difficulty: Medium
    */
    public class Solution {
        private void search(int[] cands, List<List<Integer>> comb, List<Integer> currList, int start, int remained) {
            if (remained < 0 || start >= cands.length) return;
            if (remained == 0) {
                comb.add(new ArrayList<Integer>(currList));
                return;
            }

            for (int i = start; i < cands.length && cands[i] <= remained; i++) {
                currList.add(cands[i]);
                search(cands, comb, currList, i, remained - cands[i]);
                currList.remove(currList.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> combo = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return combo;
            Arrays.sort(candidates);
            search(candidates, combo, new ArrayList<>(), 0, target);
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
                                List<Integer> t = new ArrayList<Integer>();
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
        private void search(int[] cands, List<List<Integer>> res, List<Integer> curr, int start, int remained) {
            if (remained < 0) return;
            if (remained == 0) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < cands.length && cands[i] <= remained; i++) {
                if (i > start && cands[i] == cands[i - 1]) continue;
                curr.add(cands[i]);
                search(cands, res, curr, i + 1, remained - cands[i]);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> comb = new ArrayList<>();
            if (candidates == null || candidates.length == 0) return comb;
            Arrays.sort(candidates);
            search(candidates, comb, new ArrayList<>(), 0, target);
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
                return new ArrayList<>();

            Arrays.sort(candidates);
            List<List<List<Integer>>> dp = new ArrayList<>();

            for (int i = 1; i <= target; i++) {
                List<List<Integer>> currList = new ArrayList<>();
                for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                    if (i == candidates[j]) currList.add(Collections.singletonList(candidates[j]));
                    else {
                        for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
                            if (candidates[j] <= l.get(0)) {
                                List<Integer> t = new ArrayList<>();
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

            for (int i = start; i <= 9 && i <= remained && currList.size() < k; i++) {
                currList.add(i);
                search(combo, currList, k, i + 1, remained - i);
                currList.remove(currList.size() - 1);
            }
        }

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> comb = new ArrayList<>();
            search(comb, new ArrayList<>(), k, 1, n);
            return comb;
        }
    }

    /*
        Combination Sum IV - Dynamic Programming
        Leetcode #377
        https://leetcode.com/problems/combination-sum-iv/
        Difficulty: Medium
    */
    public class Solution_6 {
        public int combinationSum4(int[] nums, int target) {
            Arrays.sort(nums);
            int[] comb = new int[target + 1];
            for (int i = 1; i < comb.length; i++) {
                for (int num : nums) {
                    if (num > i)
                        break;
                    else if (num == i)
                        comb[i] += 1;
                    else
                        comb[i] += comb[i - num];
                }
            }
            return comb[target];
        }
    }


}
