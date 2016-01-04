package search_for_a_range;

public class SearchforaRange {
    /*
        Search for a Range
        https://leetcode.com/problems/search-for-a-range/
        Difficulty: Medium
     */
    public class Solution {
        private int lowerBound(int[] A, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (A[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        public int[] searchRange(int[] nums, int target) {
            int[] rslt = new int[2];
            int begin = lowerBound(nums, 0, nums.length - 1, target);
            if (begin < nums.length && nums[begin] == target) {
                rslt[0] = begin;
                rslt[1] = lowerBound(nums, begin + 1, nums.length - 1, target + 1) - 1;
            } else {
                rslt[0] = -1;
                rslt[1] = -1;
            }
            return rslt;
        }
    }

    public class SolutionII {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return null;
            }

            int[] arr = new int[2];
            arr[0] = -1;
            arr[1] = -1;

            binarySearch(nums, 0, nums.length - 1, target, arr);

            return arr;
        }

        public void binarySearch(int[] nums, int left, int right, int target, int[] arr) {
            if (right < left)
                return;

            if (nums[left] == nums[right] && nums[left] == target) {
                arr[0] = left;
                arr[1] = right;
                return;
            }

            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                binarySearch(nums, mid + 1, right, target, arr);
            } else if (nums[mid] > target) {
                binarySearch(nums, left, mid - 1, target, arr);
            } else {
                arr[0] = mid;
                arr[1] = mid;

                //handle duplicates - left
                int t1 = mid;
                while (t1 > left && nums[t1] == nums[t1 - 1]) {
                    t1--;
                    arr[0] = t1;
                }

                //handle duplicates - right
                int t2 = mid;
                while (t2 < right && nums[t2] == nums[t2 + 1]) {
                    t2++;
                    arr[1] = t2;
                }
                return;
            }
        }
    }

    public static class UnitTest {

    }
}
