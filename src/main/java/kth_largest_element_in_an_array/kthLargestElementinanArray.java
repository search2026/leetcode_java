package kth_largest_element_in_an_array;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class kthLargestElementinanArray {
    /*
        Kth Largest number in an Array - QuickSelect
        Leetcode #215
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution {
        private void swap(int[] nums, int l, int r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
        }

        private int quickSelect(int[] nums, int start, int end, int k) {
            int l = start;
            int r = end;
            int pivot = end;
            while (l < r) {
                while (l < r && nums[l] < nums[pivot]) l++;
                while (l < r && nums[r] >= nums[pivot]) r--;
                if (l >= r) break;
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


    /*
        Kth Largest number in an Array - QuickSelect + Shuffle
        Leetcode #215
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution_2 {
        private void swap(int[] a, int i, int j) {
            final int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private int partition(int[] a, int start, int end) {
            int l = start;
            int r = end + 1;
            int pivot = start;
            while(true) {
                while(l < end && (a[++l] < a[pivot]));
                while(r > start && (a[pivot] < a[--r]));
                if(l >= r) break;
                swap(a, l, r);
            }
            swap(a, pivot, r);
            return r;
        }

        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                final int j = partition(nums, left, right);
                if(j < k) {
                    left = j + 1;
                } else if (j > k) {
                    right = j - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }
    }

    /*
        Kth Largest number in an Array - QuickSelect + Shuffle
        Leetcode #215
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution_3 {
        private void swap(int[] a, int i, int j) {
            final int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }

        private int partition(int[] a, int start, int end) {
            int l = start;
            int r = end + 1;
            int pivot = start;
            while(true) {
                while(l < end && (a[++l] < a[pivot]));
                while(r > start && (a[pivot] < a[--r]));
                if(l >= r) break;
                swap(a, l, r);
            }
            swap(a, pivot, r);
            return r;
        }

        private void shuffle(int a[]) {
            final Random random = new Random();
            for(int ind = 1; ind < a.length; ind++) {
                final int r = random.nextInt(ind + 1);
                swap(a, ind, r);
            }
        }

        public int findKthLargest(int[] nums, int k) {
            shuffle(nums);
            k = nums.length - k;
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                final int j = partition(nums, left, right);
                if(j < k) {
                    left = j + 1;
                } else if (j > k) {
                    right = j - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }
    }
    /*
        Kth Largest number in an Array - Using heap
        Leetcode #215
        https://leetcode.com/problems/kth-largest-element-in-an-array/
        Difficulty: Medium
     */
    public class Solution_4 {
        public int findKthLargest(int[] nums, int k) {
            Queue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);
                if (pq.size() > k) pq.poll();
            }
            return pq.peek();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new kthLargestElementinanArray().new Solution();
            assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }

        @Test
        public void test2() {
            Solution_2 sol = new kthLargestElementinanArray().new Solution_2();
            assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }

        @Test
        public void test3() {
            Solution_3 sol = new kthLargestElementinanArray().new Solution_3();
            assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }

        @Test
        public void test4() {
            Solution_4 sol = new kthLargestElementinanArray().new Solution_4();
            assertEquals(5, sol.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        }
    }
}
