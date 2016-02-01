package code_sample;

import org.junit.Test;

public class CodeSample {
    /*
     */
    public class Solution {
        public  void main(String[] args) {
            System.out.println("Hello World!");
        }
    }


    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CodeSample().new Solution();
        }
    }
}

