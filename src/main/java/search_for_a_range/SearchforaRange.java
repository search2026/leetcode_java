package search_for_a_range;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchforaRange {
    /*
        Search for a Range - Increase Target
        Leetcode #34
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
     */
    public class Solution {
        // the same as lower_bound in C++ STL.
        private int lowerBound(int[] nums, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            int begin = lowerBound(nums, 0, nums.length - 1, target);
            if (begin < nums.length && nums[begin] == target) {
                range[0] = begin;
                range[1] = lowerBound(nums, begin + 1, nums.length - 1, target + 1) - 1;
            }
            return range;
        }
    }

    /*
        Search for a Range - With Flag
        Leetcode #34
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
    */
    public class Solution_2 {
        private int search(int[] nums, int left, int right, int target, boolean turnLeft) {
            if (left > right) return -1;

            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                return search(nums, mid + 1, right, target, turnLeft);
            } else if (nums[mid] > target) {
                return search(nums, left, mid - 1, target, turnLeft);
            }

            if (turnLeft) {
                if (mid == 0 || nums[mid - 1] < nums[mid]) {
                    return mid;
                } else {
                    return search(nums, left, mid - 1, target, turnLeft);
                }
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > nums[mid]) {
                    return mid;
                } else {
                    return search(nums, mid + 1, right, target, turnLeft);
                }
            }
        }

        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            if (nums.length <= 0) return range;

            int begin = search(nums, 0, nums.length - 1, target, true);
            if (begin >= 0 && begin < nums.length && nums[begin] == target) {
                range[0] = begin;
                range[1] = search(nums, begin, nums.length - 1, target, false);
            }
            return range;
        }
    }

    /*
        Search for a Range - One Binary Search
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
    */
    public class Solution_3 {
        public int[] searchRange(int[] nums, int target) {
            int[] range = {-1, -1};
            int left = 0, right = nums.length - 1;

            while (nums[left] < nums[right]) {
                int mid = left + (right - left) / 2;
                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    if (nums[left] == nums[mid]) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }

            if (nums[left] == nums[right] && nums[left] == target) {
                range[0] = left;
                range[1] = right;
            }

            return range;
        }
    }

    /*
        Search for a Range - Two Binary Search
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
    */
    public class Solution_4 {
        public int[] searchRange(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            int[] res = {-1, -1};
            // Search for the left one
            while (i < j) {
                int mid = (i + j) / 2;
                if (nums[mid] < target) i = mid + 1;
                else j = mid;
            }
            if (nums[i] != target) return res;
            else res[0] = i;
            // Search for the right one
            j = nums.length - 1;
            while (i < j) {
                int mid = (i + j) / 2 + 1;
                if (nums[mid] > target) j = mid - 1;
                else i = mid;
            }
            res[1] = j;
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SearchforaRange().new Solution();
            int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
            int[] range = sol.searchRange(test, 0);
            assertEquals(range[0], 0);
            assertEquals(range[1], 2);

            range = sol.searchRange(test, 2);
            assertEquals(range[0], 3);
            assertEquals(range[1], 3);

            range = sol.searchRange(test, 4);
            assertEquals(range[0], -1);
            assertEquals(range[1], -1);

            range = sol.searchRange(test, 5);
            assertEquals(range[0], 4);
            assertEquals(range[1], 5);

            range = sol.searchRange(test, 7);
            assertEquals(range[0], 7);
            assertEquals(range[1], 8);
        }

        @Test
        public void test2() {
            Solution_2 sol = new SearchforaRange().new Solution_2();
            int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
            int[] range = sol.searchRange(test, 0);
            assertEquals(range[0], 0);
            assertEquals(range[1], 2);

            range = sol.searchRange(test, 2);
            assertEquals(range[0], 3);
            assertEquals(range[1], 3);

            range = sol.searchRange(test, 4);
            assertEquals(range[0], -1);
            assertEquals(range[1], -1);

            range = sol.searchRange(test, 5);
            assertEquals(range[0], 4);
            assertEquals(range[1], 5);

            range = sol.searchRange(test, 7);
            assertEquals(range[0], 7);
            assertEquals(range[1], 8);
        }

        @Test
        public void test3() {
            Solution_3 sol = new SearchforaRange().new Solution_3();
            int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
            int[] range = sol.searchRange(test, 0);
            assertEquals(range[0], 0);
            assertEquals(range[1], 2);

            range = sol.searchRange(test, 2);
            assertEquals(range[0], 3);
            assertEquals(range[1], 3);

            range = sol.searchRange(test, 4);
            assertEquals(range[0], -1);
            assertEquals(range[1], -1);

            range = sol.searchRange(test, 5);
            assertEquals(range[0], 4);
            assertEquals(range[1], 5);

            range = sol.searchRange(test, 7);
            assertEquals(range[0], 7);
            assertEquals(range[1], 8);
        }

        @Test
        public void test4() {
            Solution_4 sol = new SearchforaRange().new Solution_4();
            int[] test = {0, 0, 0, 2, 5, 5, 6, 7, 7};
            int[] range = sol.searchRange(test, 0);
            assertEquals(range[0], 0);
            assertEquals(range[1], 2);

            range = sol.searchRange(test, 2);
            assertEquals(range[0], 3);
            assertEquals(range[1], 3);

            range = sol.searchRange(test, 4);
            assertEquals(range[0], -1);
            assertEquals(range[1], -1);

            range = sol.searchRange(test, 5);
            assertEquals(range[0], 4);
            assertEquals(range[1], 5);

            range = sol.searchRange(test, 7);
            assertEquals(range[0], 7);
            assertEquals(range[1], 8);
        }
    }
}
