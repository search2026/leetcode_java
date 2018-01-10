package factor_combinations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FactorCombinations {
    /*
        Factor Combinations
        Leetcode #254
        https://leetcode.com/discuss/questions/oj/factor-combinations?sort=votes
        http://www.cnblogs.com/EdwardLiu/p/5068718.html
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> getFactors(int n) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            List<Integer> cur = new ArrayList<Integer>();
            if (n <= 3) return rslt;
            search(2, n, rslt, cur);
            return rslt;
        }

        public void search(int start, int n, List<List<Integer>> rslt, List<Integer> cur) {
            if (n == 1) {
                if (cur.size() > 1) {
                    rslt.add(new ArrayList<Integer>(cur));
                    return;
                }
            }
            for (int i = start; i <= n; i++) {
                if (n % i == 0) {
                    cur.add(i);
                    search(i, n / i, rslt, cur);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FactorCombinations().new Solution();
            assertTrue(true);
        }
    }
}
