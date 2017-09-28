package flatten_nested_list_iterator;

import common.NestedInteger;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;


public class FlattenNestedListIterator {
    /*
        Flatten Nested List Iterator
        Leetcode #341
        https://leetcode.com/problems/flatten-nested-list-iterator/
        Difficulty: Medium
     */
    public class NestedIterator implements Iterator<Integer> {
        Deque<NestedInteger> stack = new ArrayDeque<>();

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

    /*
        Flatten Nested List Iterator
        Leetcode #341
        https://leetcode.com/problems/flatten-nested-list-iterator/
        Difficulty: Medium
     */
    public class NestedIterator_2 implements Iterator<Integer> {
        Deque<NestedInteger> s;

        public NestedIterator_2(List<NestedInteger> nestedList) {
            s = new ArrayDeque<>(nestedList == null ? Arrays.asList() : nestedList);
        }

        @Override
        public Integer next() {
            return s.pollFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!s.isEmpty() && !s.peekFirst().isInteger()) {
                List<NestedInteger> list = s.pollFirst().getList();
                for (int i = list.size() - 1; i >= 0; i--) s.addFirst(list.get(i));
            }
            return !s.isEmpty();
        }
    }

    /*
        Flatten Nested List Iterator
        Leetcode #341
        https://leetcode.com/problems/flatten-nested-list-iterator/
        Difficulty: Medium
     */
    public class NestedIterator_3 implements Iterator<Integer> {
        NestedInteger nextInt;
        Stack<Iterator<NestedInteger>> stack;

        public NestedIterator_3(List<NestedInteger> nestedList) {
            stack = new Stack<Iterator<NestedInteger>>();
            stack.push(nestedList.iterator());
        }

        @Override
        public Integer next() {
            return nextInt != null ? nextInt.getInteger() : null; //Just in case
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (!stack.peek().hasNext()) stack.pop();
                else if ((nextInt = stack.peek().next()).isInteger()) return true;
                else stack.push(nextInt.getList().iterator());
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

