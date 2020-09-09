package com.search2026.leetcode.problems;

import java.util.*;

public class Permutations {

    /*
        Permutations - Backtracking with DFS Recursion
        Leetcode #46
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution {
        private void search(int[] nums, List<List<Integer>> permList, List<Integer> curr, boolean[] visited, int n) {
            if (curr.size() == n) {
                permList.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    curr.add(nums[i]);
                    visited[i] = true;
                    search(nums, permList, curr, visited, n);
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
            search(nums, permList, new ArrayList<Integer>(), visited, n);

            return permList;
        }
    }

    /*
        Permutations - Backtracking with BFS Iterative
        Leetcode #46
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution_2 {
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
        Permutations II - Backtracking with DFS Recursion
        Leetcode #47
        https://leetcode.com/problems/permutations-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private void search(int[] nums, List<List<Integer>> permList, List<Integer> curr, boolean[] visited, int n) {
            if (curr.size() == n) {
                permList.add(new ArrayList<>(curr));
                return;
            }

            for (int i = 0; i < n; i++) {
                if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) continue;
                if (!visited[i]) {
                    visited[i] = true;
                    curr.add(nums[i]);
                    search(nums, permList, curr, visited, n);
                    curr.remove(curr.size() - 1);
                    visited[i] = false;
                }
            }
        }

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;

            int n = nums.length;
            boolean[] visited = new boolean[n];
            Arrays.sort(nums);

            search(nums, res, new ArrayList<>(), visited, n);
            return res;
        }
    }

    /*
        Permutations II - Backtracking with BFS Iterative
        Leetcode #47
        https://leetcode.com/problems/permutations-ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Set<List<Integer>> permSet = new HashSet<>();

            int n = nums.length;
            if (n == 0) return new ArrayList<>();

            permSet.add(Arrays.asList(nums[0]));
            for (int idx = 1; idx < n; idx++) {
                Set<List<Integer>> newPermutations = new HashSet<>();
                for (List<Integer> list : permSet) {

                    for (int innerIndex = 0; innerIndex <= list.size(); innerIndex++) {
                        List<Integer> newList = new ArrayList<>(list);
                        newList.add(innerIndex, nums[idx]);
                        newPermutations.add(newList);
                    }
                }

                permSet = newPermutations;
            }

            return new ArrayList<>(permSet);
        }
    }

}
