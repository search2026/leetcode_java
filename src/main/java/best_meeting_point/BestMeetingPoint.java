package best_meeting_point;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BestMeetingPoint {
    /*
        Best Meeting Point
        Leetcode #296
        https://leetcode.com/discuss/questions/oj/best-meeting-point?sort=votes
        http://buttercola.blogspot.com/2015/10/leetcode-best-meeting-point.html
        Difficulty: Hard
     */
    public class Solution {
        public int minTotalDistance(int[][] grid) {
            if (grid == null || grid.length == 0) {
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;

            List<Integer> rowIndex = new ArrayList<Integer>();
            List<Integer> colIndex = new ArrayList<Integer>();

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rowIndex.add(i);
                        colIndex.add(j);
                    }
                }
            }

            int sum = 0;
            int mid = rowIndex.get(rowIndex.size() / 2);
            for (int x : rowIndex) {
                sum += Math.abs(x - mid);
            }

            Collections.sort(colIndex);
            mid = colIndex.get(colIndex.size() / 2);

            for (int y : colIndex) {
                sum += Math.abs(y - mid);
            }

            return sum;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new BestMeetingPoint().new Solution();
            assertTrue(true);
        }
    }
}
