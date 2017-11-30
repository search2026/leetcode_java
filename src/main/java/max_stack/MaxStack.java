package max_stack;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class MaxStack {
    /*
        Max Stack - Two Stacks
        Leetcode #716
        https://segmentfault.com/q/1010000012119679
        https://discuss.leetcode.com/category/1579/max-stack
        Difficulty: Hard
     */
    public class Solution {
        Stack<Integer> stack;
        Stack<Integer> maxStack;

        public Solution() {
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            pushHelper(x);
        }

        private void pushHelper(int x) {
            int tempMax = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
            if (x > tempMax) {
                tempMax = x;
            }
            stack.push(x);
            maxStack.push(tempMax);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            int max = maxStack.peek();
            Stack<Integer> temp = new Stack<>();

            while (stack.peek() != max) {
                temp.push(stack.pop());
                maxStack.pop();
            }
            stack.pop();
            maxStack.pop();
            while (!temp.isEmpty()) {
                int x = temp.pop();
                pushHelper(x);
            }
            return max;
        }
    }


    /*
        Max Stack - PriorityQueue + Map + Doubly Linked Node
        https://segmentfault.com/q/1010000012119679
        https://discuss.leetcode.com/category/1579/max-stack
        Difficulty: Hard
     */
    public class Solution_2 {
        class DLNode {
            DLNode prev;
            DLNode next;
            int val;

            public DLNode(int x) {
                val = x;
                prev = null;
                next = null;
            }
        }

        int FAKE = 10000007;

        PriorityQueue<Integer> q;
        Map<Integer, List<DLNode>> m;
        DLNode tail;

        /**
         * initialize your data structure here.
         */
        public Solution_2() {
            q = new PriorityQueue();
            m = new HashMap();
            tail = new DLNode(FAKE);
        }

        public void push(int x) {
            DLNode node = new DLNode(x);
            if (!m.containsKey(x)) m.put(x, new ArrayList());
            List<DLNode> l = m.get(x);
            if (l.size() == 0) q.add(-x);
            l.add(node);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        public int pop() {
            DLNode node = tail;
            int x = node.val;
            List<DLNode> l = m.get(x);
            l.remove(l.size() - 1);
            if (l.size() == 0) q.remove(-x);
            tail = node.prev;
            tail.next = null;
            return x;
        }

        public int top() {
            return tail.val;
        }

        public int peekMax() {
            return -1 * q.peek();
        }

        public int popMax() {
            int x = -1 * q.peek();
            List<DLNode> l = m.get(x);
            DLNode node = l.get(l.size() - 1);
            if (node == tail) return pop();
            l.remove(l.size() - 1);
            DLNode p = node.prev;
            DLNode n = node.next;
            p.next = n;
            n.prev = p;
            if (l.size() == 0) q.poll();
            return x;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaxStack().new Solution();
            sol.push(5);
            sol.push(1);
            sol.push(5);
            assertEquals(5, sol.top());
            assertEquals(5, sol.popMax());
            assertEquals(1, sol.top());
            assertEquals(5, sol.peekMax());
            assertEquals(1, sol.pop());
            assertEquals(5, sol.top());
        }

        @Test
        public void test2() {
            Solution_2 sol = new MaxStack().new Solution_2();
            sol.push(5);
            sol.push(1);
            sol.push(5);
            assertEquals(5, sol.top());
            assertEquals(5, sol.popMax());
            assertEquals(1, sol.top());
            assertEquals(5, sol.peekMax());
            assertEquals(1, sol.pop());
            assertEquals(5, sol.top());
        }
    }
}

