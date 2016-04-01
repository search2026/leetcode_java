package nested_list_weight_sum;

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
        class NestedInteger {
            Object self;

            // Returns true if this com.sada.linkedin.NestedInteger holds a single integer, rather than a nested list
            public boolean isInteger() {
                if (self instanceof String) {
                    return true;
                }
                return false;
            }

            // Returns the single integer that this com.sada.linkedin.NestedInteger holds, if it holds a single integer
            // Returns null if this com.sada.linkedin.NestedInteger holds a nested list
            public Integer getInteger() {
                return Integer.valueOf(self.toString());
            }

            // Returns the nested list that this com.sada.linkedin.NestedInteger holds, if it holds a nested list
            // Returns null if this com.sada.linkedin.NestedInteger holds a single integer
            public List<NestedInteger> getList() {
                if (!isInteger()) {
                    return (List<NestedInteger>) self;
                }

                return null;
            }
        }

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

