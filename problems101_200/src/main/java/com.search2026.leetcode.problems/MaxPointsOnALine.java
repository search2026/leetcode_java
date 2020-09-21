package com.search2026.leetcode.problems;

import java.awt.*;
import java.util.HashMap;

public class MaxPointsOnALine {

    /*
        Max Points on a Line
        Leetcode #169
        https://leetcode.com/problems/max-points-on-a-line/
        Difficulty: Hard
     */
    public class Solution {
        public int maxPoints(Point[] points) {
            if (points == null || points.length == 0) return 0;
            int maxPoints = 0;
            int n = points.length;
            if (n == 1) return 1;
            for (int i = 0; i < n - 1; i++) {
                HashMap<Double, Integer> map = new HashMap<>();
                int ss = 1, sp = 0; // same slope and same point
                for (int j = i + 1; j < n; j++) {
                    double slope = Double.MIN_VALUE;
                    if (points[i].x != points[j].x) {
                        slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
                        if (slope == -0.0) slope = 0.0;
                    } else if (points[i].y == points[j].y) {
                        sp += 1;
                        continue;
                    }

                    int curr = map.getOrDefault(slope, 1) + 1;
                    map.put(slope, curr);
                    ss = Math.max(ss, curr);
                }
                maxPoints = Math.max(maxPoints, ss + sp);
            }
            return maxPoints;
        }
    }

}
