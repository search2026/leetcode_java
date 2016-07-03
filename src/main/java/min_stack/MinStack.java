package min_stack;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

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

  public static class UnitTest {
    @Test
    public void test1() {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      assertEquals(-3, minStack.getMin());
      minStack.pop();
      assertEquals(0, minStack.top());
      assertEquals(-2, minStack.getMin());
    }
  }
}
