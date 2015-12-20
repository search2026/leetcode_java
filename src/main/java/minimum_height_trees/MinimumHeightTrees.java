package minimum_height_trees;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MinimumHeightTrees {
    /*
        Minimum Height Trees
        https://leetcode.com/problems/minimum-height-trees/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> leaves = new ArrayList<Integer>();
            if (n == 0)
                return leaves;
            if (n == 1) {
                leaves.add(0);
                return leaves;
            }

            Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
            for (int i = 0; i < n; i++)
                map.put(i, new HashSet<Integer>());

            // dual way
            for (int[] pair : edges) {
                map.get(pair[0]).add(pair[1]);
                map.get(pair[1]).add(pair[0]);
            }

            // one leaf
            for (int i = 0; i < n; i++) {
                if (map.get(i).size() == 1)
                    leaves.add(i);
            }

            // when n==2, there is only one level, which are the roots of min height
            while (n > 2) {
                List<Integer> newLeaves = new ArrayList<Integer>();
                for (int leaf : leaves) {
                    for (int neighbor : map.get(leaf)) {
                        // dechain
                        map.get(leaf).remove(neighbor);
                        map.get(neighbor).remove(leaf);
                        n--;

                        if (map.get(neighbor).size() == 1)
                            newLeaves.add(neighbor);
                    }
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
        }
    }
}
