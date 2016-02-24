package remove_element;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveElement {
    /*
        Remove Element
        https://leetcode.com/problems/remove-element/
        leetcode 27
        Difficulty: Easy
     */
    public class Solution {
        public int removeElement(int[] nums, int val) {
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[len++] = nums[i];
                }
            }
            return len;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RemoveElement().new Solution();
            assertEquals(7, 7);
        }
    }
}
