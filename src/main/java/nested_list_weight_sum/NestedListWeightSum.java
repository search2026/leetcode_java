package nested_list_weight_sum;

import common.NestedInteger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NestedListWeightSum {
    /*
        Nested List Weight Sum
        Leetcode #339
        https://leetcode.com/discuss/questions/oj/nested-list-weight-sum
        http://www.cnblogs.com/grandyang/p/5340305.html
        Difficulty: Easy
     */
    public class Solution {
        int depthSum(List<NestedInteger> nestedList) {
            int res = 0;
            for (NestedInteger a : nestedList) {
                res += getSum(a, 1);
            }
            return res;
        }

        int getSum(NestedInteger ni, int level) {
            int res = 0;
            if (ni.isInteger()) return level * ni.getInteger();
            for (NestedInteger a : ni.getList()) {
                res += getSum(a, level + 1);
            }
            return res;
        }
    }

    /*
        Nested List Weight Sum
        Leetcode #339
        https://leetcode.com/discuss/questions/oj/nested-list-weight-sum
        https://leetcode.com/discuss/94956/2ms-easy-to-understand-java-solution
        Difficulty: Easy
     */
    public class Solution_2 {
        private int search(List<NestedInteger> list, int depth) {
            int rslt = 0;
            for (NestedInteger e : list) {
                rslt += e.isInteger() ? e.getInteger() * depth : search(e.getList(), depth + 1);
            }
            return rslt;
        }

        public int depthSum(List<NestedInteger> nestedList) {
            return search(nestedList, 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new NestedListWeightSum().new Solution();
            assertEquals(1, 1);
        }
    }
}

