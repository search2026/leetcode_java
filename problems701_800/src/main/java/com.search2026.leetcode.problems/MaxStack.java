package com.search2026.leetcode.problems;

import java.util.*;

public class MaxStack {

    /*
        Max Stack - Two Stacks
        Leetcode #716
        https://leetcode.com/articles/max-stack/
        https://discuss.leetcode.com/category/1579/max-stack
        Difficulty: Easy
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
        Max Stack - PriorityQueue + Stack
        Leetcode #716
        https://leetcode.com/articles/max-stack/
        https://discuss.leetcode.com/category/1579/max-stack
        Difficulty: Hard
     */
    public class Solution_2 {
        Stack<Integer> s;
        PriorityQueue<Integer> pq;

        public Solution_2() {
            s = new Stack<>();
            pq = new PriorityQueue<>(10000, Collections.reverseOrder());
        }

        public void push(int x) {
            s.push(x);
            pq.offer(x);
        }

        public int pop() {
            int pop = s.pop();
            pq.remove(pop);
            return pop;
        }

        public int top() {
            return s.peek();
        }

        public int peekMax() {
            return pq.peek();
        }

        public int popMax() {
            int max = pq.poll();
            Stack<Integer> ts = new Stack<>();
            while (!s.isEmpty()) {
                if (s.peek() != max) {
                    ts.push(s.pop());
                } else {
                    s.pop();
                    break;
                }
            }
            while (!ts.isEmpty()) {
                s.push(ts.pop());
            }
            return max;
        }
    }

    /*
        Max Stack - PriorityQueue + Map + Doubly Linked Node
        Leetcode #716
        https://leetcode.com/articles/max-stack/
        https://discuss.leetcode.com/category/1579/max-stack
        Difficulty: Hard
     */
    public class Solution_3 {
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
        Map<Integer, List<DLNode>> map;
        DLNode tail;

        /**
         * initialize your data structure here.
         */
        public Solution_3() {
            q = new PriorityQueue<>();
            map = new HashMap<>();
            tail = new DLNode(FAKE);
        }

        public void push(int x) {
            DLNode node = new DLNode(x);
            if (!map.containsKey(x)) map.put(x, new ArrayList<>());
            List<DLNode> l = map.get(x);
            if (l.size() == 0) q.add(-x);
            l.add(node);
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        public int pop() {
            DLNode node = tail;
            int x = node.val;
            List<DLNode> l = map.get(x);
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
            List<DLNode> l = map.get(x);
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

}
