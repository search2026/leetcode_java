package com.search2026.leetcode.problems;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /*
        Implement Queue using Stacks
        Leetcode #232
        https://leetcode.com/problems/implement-queue-using-stacks/
        Difficulty: Easy
     */
    public class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            this.stack1 = new Stack<Integer>();
            this.stack2 = new Stack<Integer>();
        }

        // Push element x to the back of queue.
        public void push(int x) {
            stack1.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            stack2.pop();
        }

        // Get the front element.
        public int peek() {
            int ret = 0;
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }

}
