package wiggle_sort;

import org.junit.Test;

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

    /*
        Wiggle Sort II
        https://leetcode.com/problems/wiggle-sort-ii/
        Difficulty: Medium
   */
    public class Solution_2 {
        public void wiggleSort(int[] nums) {
            int medium = findMedium(nums, 0, nums.length - 1, (nums.length + 1) >> 1);
            int s = 0, t = nums.length - 1, mid_index = (nums.length + 1) >> 1;
            int[] temp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < medium)
                    temp[s++] = nums[i];
                else if (nums[i] > medium)
                    temp[t--] = nums[i];
            }

            while (s < mid_index) temp[s++] = medium;
            while (t >= mid_index) temp[t--] = medium;

            t = nums.length;
            for (int i = 0; i < nums.length; i++)
                nums[i] = (i & 1) == 0 ? temp[--s] : temp[--t];
        }

        private int findMedium(int[] nums, int L, int R, int k) {
            if (L >= R) return nums[R];
            int i = partition(nums, L, R);
            int cnt = i - L + 1;
            if (cnt == k) return nums[i];
            return cnt > k ? findMedium(nums, L, i - 1, k) : findMedium(nums, i + 1, R, k - cnt);
        }

        private int partition(int[] nums, int L, int R) {
            int val = nums[L];
            int i = L, j = R + 1;
            while (true) {
                while (++i < R && nums[i] < val) ;
                while (--j > L && nums[j] > val) ;
                if (i >= j) break;
                swap(nums, i, j);
            }
            swap(nums, L, j);
            return j;
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

