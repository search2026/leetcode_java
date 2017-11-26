package contains_duplicate;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicate {
    /*
        Contains Duplicate - Set
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
            HashSet<Integer> set = new HashSet<>();
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
    public class Solution_2 {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    if (Math.abs(map.get(nums[i]) - i) <= k) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        }
    }

    /*
        Contains Duplicates III - Bucket
        Leetcode #220
        https://leetcode.com/problems/contains-duplicate-iii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private long getID(long i, long w) {
            return i < 0 ? (i + 1) / w - 1 : i / w;
        }

        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (t < 0) return false;
            Map<Long, Long> d = new HashMap<>();
            long w = (long) t + 1;
            for (int i = 0; i < nums.length; ++i) {
                long m = getID(nums[i], w);
                if (d.containsKey(m))
                    return true;
                if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                    return true;
                if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                    return true;
                d.put(m, (long) nums[i]);
                if (i >= k) d.remove(getID(nums[i - k], w));
            }
            return false;
        }
    }

    /*
        Contains Duplicates III - Bucket
        Leetcode #220
        https://leetcode.com/problems/contains-duplicate-iii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            if (k < 1 || t < 0) return false;
            Map<Long, Long> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
                long bucket = remappedNum / ((long) t + 1);
                if (map.containsKey(bucket)
                        || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                    return true;
                if (map.entrySet().size() >= k) {
                    long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                    map.remove(lastBucket);
                }
                map.put(bucket, remappedNum);
            }
            return false;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ContainsDuplicate().new Solution();
            int[] nums = {1, 9, 21, 18, -5};
            assertFalse(sol.containsDuplicate(nums));
            nums = new int[]{1, 9, 21, 18, -5, 7, 21, 3};
            assertTrue(sol.containsDuplicate(nums));
        }

        @Test
        public void test2() {
            Solution_2 sol = new ContainsDuplicate().new Solution_2();
            int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
            assertTrue(sol.containsNearbyDuplicate(nums, 10));
            assertFalse(sol.containsNearbyDuplicate(nums, 2));
        }

        @Test
        public void test3() {
            Solution_3 sol = new ContainsDuplicate().new Solution_3();
            int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
            assertTrue(sol.containsNearbyAlmostDuplicate(nums, 10, 2));
            assertFalse(sol.containsNearbyAlmostDuplicate(nums, 2, 2));
        }

        @Test
        public void test4() {
            Solution_4 sol = new ContainsDuplicate().new Solution_4();
            int[] nums = {1, 9, 21, 18, -5, 7, 21, 3};
            assertTrue(sol.containsNearbyAlmostDuplicate(nums, 10, 2));
            assertFalse(sol.containsNearbyAlmostDuplicate(nums, 2, 2));
        }
    }
}
