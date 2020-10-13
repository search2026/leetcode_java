package com.search2026.leetcode.problems;

import java.util.*;

public class MinimumHeightTrees {

    /*
        Minimum Height Trees
        Leetcode #310
        https://leetcode.com/problems/minimum-height-trees/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> leaves = new ArrayList<>();
            if (n == 0) return leaves;
            if (n == 1) {
                leaves.add(0);
                return leaves;
            }

            Map<Integer, Set<Integer>> graph = new HashMap<>();

            // build graph
            for (int i = 0; i < n; i++)
                graph.put(i, new HashSet<>());
            for (int[] pair : edges) {
                graph.get(pair[0]).add(pair[1]);
                graph.get(pair[1]).add(pair[0]);
            }

            // findRoot the leaves
            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() == 1)
                    leaves.add(i);
            }

            // topological sort until n<=2
            while (n > 2) {
                List<Integer> newLeaves = new ArrayList<>();
                for (int leaf : leaves) {
                    for (int neighbor : graph.get(leaf)) {
                        graph.get(leaf).remove(neighbor);
                        graph.get(neighbor).remove(leaf);

                        if (graph.get(neighbor).size() == 1)
                            newLeaves.add(neighbor);
                    }
                    n--;
                }
                leaves = newLeaves;
            }

            return leaves;
        }
    }

}
