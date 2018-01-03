package subsets;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class Subsets {
    /*
        Subsets - Recursion
        Leetcode #78
        https://leetcode.com/problems/subsets/
        Difficulty: Medium
     */
    public class Solution {
        private void combine(List<List<Integer>> res, List<Integer> curr, int[] nums, int k, int start) {
            if (curr.size() == k) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int j = start; j <= nums.length - 1; j++) {
                curr.add(nums[j]);
                combine(res, curr, nums, k, j + 1);
                curr.remove(curr.size() - 1);
            }
        }

        public List<List<Integer>> subsets(int[] nums) {
            Arrays.sort(nums);
            List<Integer> curr = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();

            for (int k = 0; k <= nums.length; k++) {
                combine(res, curr, nums, k, 0);
            }
            return res;
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
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < 1 << nums.length; i++) {
                List<Integer> curr = new ArrayList<>();
                int n = i;
                int idx = 0;
                while (n > 0) {
                    if ((n & 1) == 1) {
                        curr.add(nums[idx]);
                    }
                    n >>= 1;
                    idx++;
                }
                res.add(curr);
            }
            return res;
        }
    }

    /*
        Subsets II - Recursion
        Leetcode #90
        https://leetcode.com/problems/subsets_ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        private void search(List<List<Integer>> res, List<Integer> curr, int[] num, int start, int len, boolean[] visited) {
            if (curr.size() == len) {
                res.add(new ArrayList<>(curr));
                return;
            }

            for (int i = start; i < num.length; i++) {
                if (i > 0 && num[i] == num[i - 1] && !visited[i - 1]) continue;
                curr.add(num[i]);
                visited[i] = true;
                search(res, curr, num, i + 1, len, visited);
                curr.remove(curr.size() - 1);
                visited[i] = false;
            }
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            Arrays.sort(nums);
            List<Integer> item = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            for (int len = 0; len <= nums.length; len++) {
                search(res, item, nums, 0, len, visited);
            }
            return res;
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
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<Integer>());
            int last = 1;
            for (int i = 0; i < nums.length; i++) {
                int start = 0;
                if (i != 0 && nums[i] == nums[i - 1]) {
                    start = last;
                }
                last = res.size();
                for (int j = start; j < last; j++) {
                    ArrayList<Integer> subset = new ArrayList<>(
                            res.get(j));
                    subset.add(nums[i]);
                    res.add(subset);
                }
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Subsets().new Solution();
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> res = sol.subsets(nums);
            assertEquals(8, res.size());
        }

        @Test
        public void test2() {
            Solution_2 sol = new Subsets().new Solution_2();
            int[] nums = new int[]{1, 2, 3};
            List<List<Integer>> res = sol.subsets(nums);
            assertEquals(8, res.size());
        }

        @Test
        public void test3() {
            Solution_3 sol = new Subsets().new Solution_3();
            int[] nums = new int[]{1, 2, 2};
            List<List<Integer>> res = sol.subsetsWithDup(nums);
            assertEquals(6, res.size());
        }

        @Test
        public void test4() {
            Solution_4 sol = new Subsets().new Solution_4();
            int[] nums = new int[]{1, 2, 2};
            List<List<Integer>> res = sol.subsetsWithDup(nums);
            assertEquals(6, res.size());
        }
    }
}
