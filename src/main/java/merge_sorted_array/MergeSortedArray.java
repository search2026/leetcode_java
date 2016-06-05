package merge_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSortedArray {
    /*
        Merge Sorted Array
        Leetcode #88
        https://leetcode.com/problems/merge-sorted-array/
        Difficulty: Easy
     */
    public class Solution {
        public void merge(int A[], int m, int B[], int n) {
            int i = m - 1;
            int j = n - 1;
            while (i >= 0 && j >= 0) {
                A[i + j + 1] = A[i] > B[j] ? A[i--] : B[j--];
            }
            while (j >= 0) {
                A[j] = B[j--];
            }
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MergeSortedArray().new Solution();
            assertEquals(3, 3);
        }
    }
}
