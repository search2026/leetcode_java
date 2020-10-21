package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {

    /*
        Nested List Weight Sum - Top Down
        Leetcode #339
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/NestedListWeightSum.md
        Difficulty: Easy
     */
    public class Solution {
        private int search(List<NestedInteger> list, int depth) {
            int sum = 0;
            for (NestedInteger ni : list) {
                sum += ni.isInteger() ? ni.getInteger() * depth : search(ni.getList(), depth + 1);
            }
            return sum;
        }

        public int depthSum(List<NestedInteger> nestedList) {
            return search(nestedList, 1);
        }
    }

    /*
        Nested List Weight Sum - Bottom Up
        Leetcode #339
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/NestedListWeightSum.md
        Difficulty: Easy
     */
    public class Solution_2 {

        public int depthSum(List<NestedInteger> nestedList) {
            int[] sum = new int[1];
            //invertedDFS(input, 1, sum);

            return sum[0];
        }
    }

    /*
        Nested List Weight Sum II - Recursive
        Leetcode #364
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/NestedListWeightSumII.md
        Difficulty: Medium
   */
    public class Solution_3 {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int unweighted = 0, weighted = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for (NestedInteger e : nestedList) {
                    if (e.isInteger())
                        unweighted += e.getInteger();
                    else
                        nextLevel.addAll(e.getList());
                }
                weighted += unweighted;
                nestedList = nextLevel;
            }
            return weighted;
        }
    }

    /*
        Nested List Weight Sum II - Recursive
        Leetcode #364
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/NestedListWeightSumII.md
        Difficulty: Medium
   */
    public class Solution_4 {
        private int search(List<NestedInteger> list, int prev) {
            int intSum = prev;
            List<NestedInteger> levelBreak = new ArrayList<>();

            for (NestedInteger ni : list) {
                if (ni.isInteger()) {
                    intSum += ni.getInteger();
                } else {
                    levelBreak.addAll(ni.getList());
                }
            }

            int listSum = levelBreak.isEmpty() ? 0 : search(levelBreak, intSum);

            return listSum + intSum;
        }

        public int depthSumInverse(List<NestedInteger> nestedList) {
            return search(nestedList, 0);
        }
    }

    /*
        Nested List Weight Sum II - Iterative
        Leetcode #364
        https://github.com/search2026/leetcode_java/blob/master/problems301_400/resources/NestedListWeightSumII.md
        Difficulty: Medium
    */
    public class Solution_5 {
        public int depthSumInverse(List<NestedInteger> nestedList) {
            int unweighted = 0, weighted = 0;
            while (!nestedList.isEmpty()) {
                List<NestedInteger> nextLevel = new ArrayList<>();
                for (NestedInteger ni : nestedList) {
                    if (ni.isInteger())
                        unweighted += ni.getInteger();
                    else
                        nextLevel.addAll(ni.getList());
                }
                weighted += unweighted;
                nestedList = nextLevel;
            }
            return weighted;
        }
    }

}
