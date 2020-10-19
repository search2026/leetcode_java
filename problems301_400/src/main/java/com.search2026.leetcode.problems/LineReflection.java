package com.search2026.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class LineReflection {

    /*
        Line Reflection
        Leetcode #356
        https://github.com/search2026/leetcode_java/blob/master/resources/LineReflection.md
        Difficulty: Medium
     */
    public class Solution {
        private final String DELIMITER = "a";

        public boolean isReflected(int[][] points) {
            if (points == null || points.length == 0 ||
                        points[0] == null || points[0].length != 2) return false;

            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            Set<String> set = new HashSet<>();
            for (int[] p : points) {
                max = Math.max(max, p[0]);
                min = Math.min(min, p[0]);
                String str = p[0] + DELIMITER + p[1];
                set.add(str);
            }

            long sum = max + min;
            for (int[] p : points) {
                String str = (sum - p[0]) + DELIMITER + p[1];
                if (!set.contains(str)) return false;
            }
            return true;
        }
    }

}
