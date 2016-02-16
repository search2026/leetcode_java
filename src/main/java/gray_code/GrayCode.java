package gray_code;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GrayCode {
    /*
        Gray Code - Formula
        https://leetcode.com/problems/gray-code/
        Difficulty: Medium
     */
    public class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> rslt = new ArrayList<Integer>();
            for (int i = 0; i < (1 << n); i++) {
                rslt.add(i ^ (i >> 1));
            }
            return rslt;
        }
    }

    /*
        Gray Code - Recursive
        https://leetcode.com/problems/gray-code/
        Difficulty: Medium
     */
    public class Solution_2 {
        public ArrayList<Integer> grayCode(int n) {
            if (n == 0) {
                ArrayList<Integer> rslt = new ArrayList<Integer>();
                rslt.add(0);
                return rslt;
            }

            ArrayList<Integer> rslt = grayCode(n - 1);
            int addNumber = 1 << (n - 1);
            int original_size = rslt.size();

            for (int i = original_size - 1; i >= 0; i--)
                rslt.add(addNumber + rslt.get(i));

            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new GrayCode().new Solution();
            assertEquals(5, 5);
        }
    }
}
