package code_sample;

import org.junit.Test;

import java.util.*;

public class CodeSample {
    /*
        Coding Sample
        For free style writing
     */
    public class Solution {
        public void main(String[] args) {
            System.out.println("Hello World!");
            int[] a = new int[10];
            char[] b = { 'a', 'b' };
            Integer[] c = {1, 2, 3};
            int[][] d = new int[10][10];
            int m = a.length;
            int n = d[0].length;
            int max = Integer.MAX_VALUE;
            int min = Integer.MIN_VALUE;
            Arrays.sort(a);
            for (int i = 0; i < c.length; i++) {
                System.out.println(c[i]);
            }
            List<Integer> list = Arrays.asList(c);
            Integer[] e = new Integer[list.size()];
            e = list.toArray(e);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CodeSample().new Solution();
        }
    }
}

