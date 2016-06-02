package code_sample;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class CodeSample {
    /*
        Coding Sample
        For free style writing
     */
    public class Solution {
        public void main(String[] args) {
            System.out.println("Hello World!");
            ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
            stack.push(2);
            stack.push(3);
            int t = stack.peek();
            t = stack.pop();
            boolean b = stack.isEmpty();


        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CodeSample().new Solution();
        }
    }
}

