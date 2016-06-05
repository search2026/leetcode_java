package subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Subsets {
    /*
        Subsets - Recursion
        Leetcode #78
        https://leetcode.com/problems/subsets/
        Difficulty: Medium
     */
    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<Integer> cur = new ArrayList<Integer>();
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();

            for (int k = 0; k <= nums.length; k++) {
                combine(cur, rslt, nums, k, 0);
            }
            return rslt;
        }

        public void combine(List<Integer> cur, List<List<Integer>> rslt, int[] nums, int k, int start) {
            if (cur.size() == k) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }

            for (int j = start; j <= nums.length - 1; j++) {
                cur.add(nums[j]);
                combine(cur, rslt, nums, k, j + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /*
        Subsets - Iterative
        Leetcode #78
        https://leetcode.com/problems/subsets/
        Difficulty: Medium
     */
    public class Solution_2 {
        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            for (int i = 0; i < 1 << nums.length; i++) {
                ArrayList<Integer> subset = new ArrayList<Integer>();
                int n = i;
                int idx = 0;
                while (n > 0) {
                    if ((n & 1) == 1) {
                        subset.add(nums[idx]);
                    }
                    n >>= 1;
                    idx++;
                }
                rslt.add(subset);
            }
            return rslt;
        }
    }

    /*
        Subsets II - Recursion
        Leetcode #90
        https://leetcode.com/problems/subsets_ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            if (nums == null || nums.length == 0) return rslt;
            Arrays.sort(nums);
            List<Integer> item = new ArrayList<Integer>();
            boolean[] visited = new boolean[nums.length];
            for (int len = 0; len <= nums.length; len++) {
                search(rslt, item, nums, 0, len, visited);
            }
            return rslt;
        }

        public void search(List<List<Integer>> rslt, List<Integer> cur, int[] num, int start, int len, boolean[] visited) {
            if (cur.size() == len) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }

            for (int i = start; i < num.length; i++) {
                if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) continue;
                cur.add(num[i]);
                visited[i] = true;
                search(rslt, cur, num, i + 1, len, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }
    }

    /*
        Subsets II - Iterative
        Leetcode #90
        https://leetcode.com/problems/subsets_ii/
        Difficulty: Medium
    */
    public class Solution_4 {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            rslt.add(new ArrayList<Integer>());
            int last = 1;
            for (int i = 0; i < nums.length; i++) {
                int start = 0;
                if (i != 0 && nums[i] == nums[i - 1]) {
                    start = last;
                }
                last = rslt.size();
                for (int j = start; j < last; j++) {
                    ArrayList<Integer> subset = new ArrayList<Integer>(
                            rslt.get(j));
                    subset.add(nums[i]);
                    rslt.add(subset);
                }
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Subsets().new Solution();
            assertTrue(true);
        }
    }
}
