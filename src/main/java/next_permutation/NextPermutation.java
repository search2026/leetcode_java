package next_permutation;

public class NextPermutation {

    public class Solution {
        private void swap(int[] num, int i, int j) {
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }

        private void reverse(int[] num, int begin, int end) {
            end--;
            while (begin < end) {
                swap(num, begin++, end--);
            }
        }

        public void nextPermutation(int[] nums) {
            if (nums.length <= 1) {
                return;
            }
            int i = nums.length - 1;
            while (i > 0) {
                i--;
                if (nums[i] < nums[i + 1]) {
                    int j = nums.length;
                    while (nums[--j] <= nums[i]) {
                    }
                    swap(nums, i, j);
                    reverse(nums, i + 1, nums.length);
                    return;
                }
            }
            reverse(nums, 0, nums.length);
        }
    }

    public static class UnitTest {

    }
}
