package permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Permutations {
    /*
        Permutations - Recursive
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution {
        public void permute(int[] num, int[] visited, int len, List<Integer> cur, List<List<Integer>> rslt) {
            if (cur.size() == len) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }

            for (int i = 0; i < len; i++) {
                if (visited[i] == 0) {
                    cur.add(num[i]);
                    visited[i] = 1;
                    permute(num, visited, len, cur, rslt);
                    visited[i] = 0;
                    cur.remove(cur.size() - 1);
                }
            }
        }

        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            List<Integer> cur = new ArrayList<Integer>();
            int len = nums.length;
            int[] visited = new int[len];
            permute(nums, visited, len, cur, rslt);
            return rslt;
        }
    }

    /*
        Permutations - Insert
        https://leetcode.com/problems/permutations/
        Difficulty: Medium
    */
    public class Solution_2 {
        public List<List<Integer>> insert(List<List<Integer>> list, int num) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < list.get(i).size() + 1; j++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(list.get(i));
                    temp.add(j, num);
                    rslt.add(temp);
                }
            }
            return rslt;
        }

        public List<List<Integer>> permute(int[] num) {
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            List<Integer> a = new ArrayList<Integer>();
            a.add(num[0]);
            rslt.add(a);
            for (int i = 1; i < num.length; i++) {
                rslt = insert(rslt, num[i]);
            }
            return rslt;
        }
    }

    /*
        Permutations II
        https://leetcode.com/problems/permutations-ii/
        Difficulty: Medium
    */
    public class Solution_3 {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            List<Integer> cur = new ArrayList<Integer>();
            List<List<Integer>> rslt = new ArrayList<List<Integer>>();
            boolean[] visited = new boolean[nums.length];

            permute(nums, visited, cur, rslt);
            return rslt;
        }

        public void permute(int[] nums, boolean[] visited, List<Integer> cur, List<List<Integer>> rslt) {
            if (cur.size() == nums.length) {
                rslt.add(new ArrayList<Integer>(cur));
                return;
            }

            for (int k = 0; k < nums.length; k++) {
                if (k > 0 && !visited[k - 1] && nums[k] == nums[k - 1]) continue;
                if (!visited[k]) {
                    visited[k] = true;
                    cur.add(nums[k]);
                    permute(nums, visited, cur, rslt);
                    cur.remove(cur.size() - 1);
                    visited[k] = false;
                }
            }
        }
    }

    public class UnitTest {
        @Test
        public void test1() {
            Solution sol = new Permutations().new Solution();
            assertTrue(true);
        }
    }
}
