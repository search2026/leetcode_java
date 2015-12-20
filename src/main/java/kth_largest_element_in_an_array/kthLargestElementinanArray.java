package kth_largest_element_in_an_array;

public class kthLargestElementinanArray {
    /*
        Kth Largest number in an Array
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution {
        public int findKthLargest(int[] nums, int k) {
            return quickSelect(nums, 0, nums.length - 1, nums.length - k);
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[right];
            int index = left;
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, index, i);
                    index++;
                }
            }
            swap(nums, index, right);
            return index;
        }

        private int quickSelect(int[] nums, int left, int right, int k) {
            if (left == right)
                return nums[left];
            int index = partition(nums, left, right);
            if (index == k)
                return nums[k];
            else if (k < index)//left
                return quickSelect(nums, left, index - 1, k);
            else//right
                return quickSelect(nums, index + 1, right, k);
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static class UnitTest {

    }
}
