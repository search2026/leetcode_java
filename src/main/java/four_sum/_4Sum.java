package four_sum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class _4Sum {
    /*
        4 Sum
        Leetcode #18
        https://leetcode.com/problems/4sum/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> fourSum(int[] num, int target) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            if (num == null) {
                return ret;
            }

            Arrays.sort(num);

            int len = num.length;
            for (int i = 0; i < len; i++) {
                if (i > 0 && num[i] == num[i - 1]) {
                    // skip duplicate.
                    continue;
                }

                for (int j = i + 1; j < len; j++) {
                    if (j > i + 1 && num[j] == num[j - 1]) {
                        // skip duplicate.
                        continue;
                    }

                    int l = j + 1;
                    int r = len - 1;

                    while (l < r) {
                        int sum = num[i] + num[j] + num[l] + num[r];
                        if (sum == target) {
                            ArrayList<Integer> list = new ArrayList<>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[l]);
                            list.add(num[r]);

                            ret.add(list);

                            do {
                                l++;
                            } while (l < r && num[l] == num[l - 1]);

                            do {
                                r--;
                            } while (l < r && num[r] == num[r + 1]);
                        } else if (sum < target) {
                            l++;
                        } else {
                            r--;
                        }
                    }
                }
            }

            return ret;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new _4Sum().new Solution();
            assertTrue(true);
        }
    }
}
