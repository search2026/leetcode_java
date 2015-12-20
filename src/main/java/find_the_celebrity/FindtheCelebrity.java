package find_the_celebrity;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FindtheCelebrity {
    /*
        Find the Celebrity
        http://buttercola.blogspot.com/2015/09/leetcode-find-celebrity.html
        Difficulty: Medium
     */
    public class Solution {
        public int findCelebrity(int n) {
            if (n <= 1) {
                return -1;
            }

            int left = 0;
            int right = n - 1;

            // Step 1: Find the potential candidate
            while (left < right) {
                if (knows(left, right)) {
                    left++;
                } else {
                    right--;
                }
            }

            // Step 2: Validate the candidate
            int candidate = right;
            for (int i = 0; i < n; i++) {
                if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
                    return -1;
                }
            }

            return candidate;
        }

        /* The knows API is defined in the parent class Relation.
        boolean knows(int a, int b); */
        private boolean knows(int a, int b) {
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindtheCelebrity().new Solution();
        }
    }
}

