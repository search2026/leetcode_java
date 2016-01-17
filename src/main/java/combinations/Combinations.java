package combinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Combinations {
    /*
        Combinations
        https://leetcode.com/problems/combinations/
        Difficulty: Medium
     */
    public class Solution {
        private void search(int start, int end, int k, ArrayList<Integer> cur, List<List<Integer>> rslt) {
            if (k == 0) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }

            for (int i = start; i <= end - k + 1; i++) {
                cur.add(i);
                search(i + 1, end, k - 1, cur, rslt);
                cur.remove(cur.size() - 1);
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            search(1, n, k, new ArrayList<Integer>(), rslt);
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Combinations().new Solution();
            assertTrue(true);
        }
    }
}
