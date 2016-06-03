package create_maximum_number;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateMaximumNumber {
    /*
        Create Maximum Number
        Leetcode #321
        https://leetcode.com/problems/create-maximum-number/
        Difficulty: Hard
     */
    public class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int[] rslt = new int[k];
            for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
                int[] res1 = get_max_sub_array(nums1, i);
                int[] res2 = get_max_sub_array(nums2, k - i);
                int[] res = new int[k];
                int pos1 = 0, pos2 = 0, tpos = 0;

                while (pos1 < res1.length || pos2 < res2.length) {
                    res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
                }

                if (!greater(rslt, 0, res, 0))
                    rslt = res;
            }

            return rslt;
        }

        public boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
            for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
                if (nums1[start1] > nums2[start2]) return true;
                if (nums1[start1] < nums2[start2]) return false;
            }
            return start1 != nums1.length;
        }

        public int[] get_max_sub_array(int[] nums, int k) {
            int[] rslt = new int[k];
            int len = 0;
            for (int i = 0; i < nums.length; i++) {
                while (len > 0 && len + nums.length - i > k && rslt[len - 1] < nums[i]) {
                    len--;
                }
                if (len < k)
                    rslt[len++] = nums[i];
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CreateMaximumNumber().new Solution();
            assertTrue(true);
        }        
    }
}

