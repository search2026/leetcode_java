package remove_duplicates_from_sorted_array;

public class RemoveDuplicatesfromSortedArray {

    public class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int len = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[len - 1] != nums[i]) {
                    nums[len++] = nums[i];
                }
            }
            return len;
        }

        // Remove Duplicates from Sorted Array
        public int removeDuplicatesII(int[] nums) {
            int len = 0;
            boolean twice = false;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1]) {
                    twice = false;
                    nums[len++] = nums[i];
                } else if (!twice) {
                    nums[len++] = nums[i];
                    twice = true;
                }
            }
            return len;
        }
    }

    public static class UnitTest {

    }
}
