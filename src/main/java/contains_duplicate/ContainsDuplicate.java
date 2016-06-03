package contains_duplicate;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.Assert.assertTrue;

public class ContainsDuplicate {
    /*
        Contains Duplicate
        Leetcode #217
        https://leetcode.com/problems/contains-duplicate/
        Difficulty: Easy
     */
    public class Solution {
        // Contains Duplicates
        // https://leetcode.com/problems/contains-duplicate/
        // Difficulty: Easy
        public boolean containsDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            HashSet<Integer> set = new HashSet<Integer>();
            for (int n : nums) {
                if (!set.add(n)) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
        Contains Duplicates II
        leetcode #219
        https://leetcode.com/problems/contains-duplicate-ii/
        Difficulty: Easy
    */
    public class SolutionII {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (Math.abs(map.get(nums[i]) - i) <= k) {
                        return true;
                    } else {
                        map.put(nums[i], i);
                    }
                } else {
                    map.put(nums[i], i);
                }
            }
            return false;
        }
    }

    /*
        Contains Duplicates III
        Leetcode #220
        https://leetcode.com/problems/contains-duplicate-iii/
        Difficulty: Medium
    */
    public class SolutionIII {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k < 1 || t < 0)
                return false;

            TreeSet<Integer> set = new TreeSet<Integer>();

            for (int i = 0; i < nums.length; i++) {
                int c = nums[i];
                if ((set.floor(c) != null && c <= set.floor(c) + t)
                        || (set.ceiling(c) != null && c >= set.ceiling(c) -t))
                    return true;

                set.add(c);

                if (i >= k)
                    set.remove(nums[i - k]);
            }

            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ContainsDuplicate().new Solution();
            assertTrue(true);
        }
    }
}
