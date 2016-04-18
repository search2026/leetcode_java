package flatten_nested_list_iterator;

import common.NestedInteger;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertEquals;


public class FlattenNestedListIterator {
    /*
        Flatten Nested List Iterator
        https://leetcode.com/problems/flatten-nested-list-iterator/
        Difficulty: Medium
     */
    public class NestedIterator implements Iterator<Integer> {
        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger curr = stack.peek();
                if (curr.isInteger()) {
                    return true;
                }
                stack.pop();
                for (int i = curr.getList().size() - 1; i >= 0; i--) {
                    stack.push(curr.getList().get(i));
                }
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            //Solution sol = new FlattenNestedListIterator().new Solution();
            assertEquals(1, 1);
        }
    }
}

