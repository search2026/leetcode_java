package search_for_a_range;

public class SearchforaRange {

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
            int[] ans = new int[2];
            int begin = lowerBound(nums, 0, nums.length - 1, target);
            if (begin < nums.length && nums[begin] == target) {
                ans[0] = begin;
                ans[1] = lowerBound(nums, begin + 1, nums.length - 1, target + 1) - 1;
            } else {
                ans[0] = -1;
                ans[1] = -1;
            }
            return ans;
        }
    }

    public static class UnitTest {

    }
}
