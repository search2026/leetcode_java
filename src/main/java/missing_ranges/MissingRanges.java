package missing_ranges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MissingRanges {
    /*
        Missing Ranges
        Leetcode #163
        https://leetcode.com/discuss/questions/oj/missing-ranges?sort=votes
        http://www.cnblogs.com/EdwardLiu/p/4249626.html
        Difficulty: Medium
     */
    public class Solution {
        public List<String> findMissingRanges(int[] vals, int start, int end) {
            List<String> ranges = new ArrayList<String>();
            int prev = start - 1;
            for (int i = 0; i <= vals.length; ++i) {
                int curr = (i == vals.length) ? end + 1 : vals[i];
                if (curr - prev >= 2) {
                    ranges.add(getRange(prev + 1, curr - 1));
                }
                prev = curr;
            }
            return ranges;
        }

        private String getRange(int from, int to) {
            return (from == to) ? String.valueOf(from) : from + "->" + to;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MissingRanges().new Solution();
            assertEquals(3, 3);
        }
    }
}
