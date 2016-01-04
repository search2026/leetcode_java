package gray_code;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    /*
        Gray Code
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

    public class Solution_2 {
        public ArrayList<Integer> grayCode(int n) {
            if (n == 0) {
                ArrayList<Integer> result = new ArrayList<Integer>();
                result.add(0);
                return result;
            }

            ArrayList<Integer> result = grayCode(n - 1);
            int addNumber = 1 << (n - 1);
            int original_size = result.size();

            for (int i = original_size - 1; i >= 0; i--) {
                result.add(addNumber + result.get(i));
            }
            return result;
        }
    }

    public static class UnitTest {

    }
}
