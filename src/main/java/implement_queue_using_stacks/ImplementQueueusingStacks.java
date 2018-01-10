package implement_queue_using_stacks;

import org.junit.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementQueueusingStacks {
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

    public static class UnitTest {
        @Test
        public void test1() {
            MyQueue sol = new ImplementQueueusingStacks().new MyQueue();
            assertEquals(3, 3);
        }
    }
}
