package com.search2026.leetcode.problems;

import java.util.ArrayDeque;
import java.util.Deque;

/*
    Min Stack
    Leetcode #155
    https://leetcode.com/problems/min-stack/
    Difficulty: Easy
 */
public class MinStack {
    private Deque<Integer> minStack = new ArrayDeque<>();
    private Deque<Integer> stack = new ArrayDeque<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.peek();
        stack.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
