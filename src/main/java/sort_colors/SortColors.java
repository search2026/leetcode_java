package sort_colors;

public class SortColors {

    public class Solution {
        public void sortColors(int[] nums) {
            int zero = -1;
            int one = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[++zero];
                    nums[zero] = 0;
                    one = Math.max(zero, one);
                }
                if (nums[i] == 1) {
                    nums[i] = nums[++one];
                    nums[one] = 1;
                }
            }
        }
    }

    public static class UnitTest {

    }
}
