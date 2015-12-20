package wiggle_sort;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class WiggleSort {
    /*
        Wiggle Sort
        http://buttercola.blogspot.com/2015/09/leetcode-wiggle-sort.html
        Difficulty: Medium
     */
    public class Solution {
        public void wiggleSort(int[] nums) {
            if (nums == null || nums.length <= 1) {
                return;
            }

            for (int i = 0; i < nums.length - 1; i++) {
                if (i % 2 == 0) {
                    if (nums[i] > nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                } else {
                    if (nums[i] < nums[i + 1]) {
                        swap(nums, i, i + 1);
                    }
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new WiggleSort().new Solution();
        }
    }
}

