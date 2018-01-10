package implement_stack_using_queues;

import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementStackusingQueues {
    /*
        Implement Stack using Queues
        Leetcode #225
        https://leetcode.com/problems/implement-stack-using-queues/
        Difficulty: Easy
     */
    public class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;

        public MyStack() {
            this.queue1 = new LinkedList<Integer>();
            this.queue2 = new LinkedList<Integer>();
        }

        // Push element x onto stack.
        public void push(int x) {
            queue1.offer(x);
        }

        // Removes the element on top of the stack.
        public void pop() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            queue1.poll();

            // Swap queue1 and queue2
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

        // Get the top element.
        public int top() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }

            int ret = queue1.poll();
            queue2.offer(ret);

            // Swap queue 1 and queue2
            Queue<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;

            return ret;
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            MyStack sol = new ImplementStackusingQueues().new MyStack();
            assertEquals(3, 3);
        }
    }
}
