package max_points_on_a_line;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxPointsonaLine {
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

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaxPointsonaLine().new Solution();
            Point[] points = new Point[1];
            points[0] = new Point(0, 0);
            assertEquals(1, sol.maxPoints(points));

            points = new Point[2];
            points[0] = new Point(0, 0);
            points[1] = new Point(0, 0);
            assertEquals(2, sol.maxPoints(points));

            points = new Point[6];
            points[0] = new Point(0, 0);
            points[1] = new Point(1, 1);
            points[2] = new Point(-1, -1);
            points[3] = new Point(-1, 0);
            points[4] = new Point(-5, 2);
            points[5] = new Point(-1, -1);
            assertEquals(4, sol.maxPoints(points));
        }
    }
}
