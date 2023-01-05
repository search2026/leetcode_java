package com.search2026.leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    /*
        Combinations - Backtracking
        Leetcode #77
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public static class Solution {
        private void search(List<List<Integer>> comb, List<Integer> curr, int start, int end, int k) {
            if (k == 0) {
                comb.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i <= end - k + 1; i++) {
                curr.add(i);
                search(comb, curr, i + 1, end, k - 1);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> combList = new ArrayList<>();
            if (k < 1 || n < k) {
                return combList;
            }

            search(combList, new ArrayList<>(), 1, n, k);

            return combList;
        }
    }

    /*
        Combinations - Iterative
        Leetcode #77
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public static class Solution_2 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> comboList = new ArrayList<>();
            if (k < 1 || n < k) {
                return comboList;
            }
            for (int i = 1; i <= n; i++) comboList.add(List.of(i));
            for (int i = 2; i <= k; i++) {
                List<List<Integer>> newCombs = new ArrayList<>();
                for (int j = i; j <= n; j++) {
                    for (List<Integer> comb : comboList) {
                        if (comb.get(comb.size() - 1) < j) {
                            List<Integer> newComb = new ArrayList<>(comb);
                            newComb.add(j);
                            newCombs.add(newComb);
                        }
                    }
                }
                comboList = newCombs;
            }
            return comboList;
        }
    }

    /*
        Combinations - Iterative
        Leetcode #77
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public static class Solution_3 {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> comboList = new ArrayList<>();
            if (k < 1 || n < k) {
                return comboList;
            }
            List<Integer> curr = new ArrayList<>();
            int i = 1;
            while (i <= n || curr.size() != 0) {
                if (curr.size() == k) comboList.add(new ArrayList<>(curr));

                if (i > n || curr.size() == k) {
                    i = curr.get(curr.size() - 1) + 1;
                    curr.remove(curr.size() - 1);
                } else {
                    curr.add(i);
                    i++;
                }
            }
            return comboList;
        }
    }

    /*
        Combinations - Dynamic Programming
        Leetcode #77
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public static class Solution_4 {
        public List<List<Integer>> combine(int n, int k) {
            if (k == n || k == 0) {
                List<Integer> row = new LinkedList<>();
                for (int i = 1; i <= k; ++i) row.add(i);
                return new LinkedList<>(List.of(row));
            }

            List<List<Integer>> comboList = this.combine(n - 1, k - 1);
            comboList.forEach(e -> e.add(n));
            comboList.addAll(this.combine(n - 1, k));
            return comboList;
        }
    }

}
