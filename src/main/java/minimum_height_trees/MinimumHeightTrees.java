package minimum_height_trees;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class MinimumHeightTrees {
    /*
        Minimum Height Trees
        Leetcode #310
        https://leetcode.com/problems/minimum-height-trees/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> leaves = new ArrayList<Integer>();
            if (n == 0) return leaves;
            if (n == 1) {
                leaves.add(0);
                return leaves;
            }

            Map<Integer, Set<Integer>> graph = new HashMap<Integer, Set<Integer>>();

            // build graph
            for (int i = 0; i < n; i++)
                graph.put(i, new HashSet<Integer>());
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
                List<Integer> newLeaves = new ArrayList<Integer>();
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MinimumHeightTrees().new Solution();
            int n = 4;
            int[][] edges = new int[][]{
                    new int[]{1, 0},
                    new int[]{1, 2},
                    new int[]{1, 3}
            };
            List<Integer> rslt = sol.findMinHeightTrees(n, edges);
            int[] tmpArray = toIntArray(rslt);
            assertArrayEquals(new int[]{1}, tmpArray);

            n = 6;
            edges = new int[][]{
                    new int[]{0, 3},
                    new int[]{1, 3},
                    new int[]{2, 3},
                    new int[]{4, 3},
                    new int[]{5, 4}
            };
            rslt = sol.findMinHeightTrees(n, edges);
            tmpArray = toIntArray(rslt);
            assertArrayEquals(new int[]{3, 4}, tmpArray);
        }

        int[] toIntArray(List<Integer> list) {
            int[] ret = new int[list.size()];
            int i = 0;
            for (Integer e : list)
                ret[i++] = e;
            return ret;
        }
    }
}
