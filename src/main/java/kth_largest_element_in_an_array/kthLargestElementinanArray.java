package kth_largest_element_in_an_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class kthLargestElementinanArray {
    /*
        Kth Largest number in an Array
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution {
        public void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        public int quickSelect(int[] nums, int start, int end, int k) {
            int l = start;
            int r = end;
            int pivot = end;
            while (l < r) {
                while (l < r && nums[l] < nums[pivot]) l++;
                while (l < r && nums[r] >= nums[pivot]) r--;
                if (l == r) break;
                swap(nums, l, r);
            }
            swap(nums, l, pivot);
            if (l + 1 == k) return nums[l];
            else if (l + 1 < k) return quickSelect(nums, l + 1, end, k);
            else return quickSelect(nums, start, l - 1, k);
        }

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            return quickSelect(nums, 0, len - 1, len - k + 1);
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new kthLargestElementinanArray().new Solution();
            assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }
    }
}
