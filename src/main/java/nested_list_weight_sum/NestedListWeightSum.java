package nested_list_weight_sum;

import common.NestedInteger;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NestedListWeightSum {
    /*
        Nested List Weight Sum
        http://www.cnblogs.com/grandyang/p/5340305.html
        Difficulty: Easy
     */
    public class Solution {
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

