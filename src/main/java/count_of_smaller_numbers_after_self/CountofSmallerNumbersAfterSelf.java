package count_of_smaller_numbers_after_self;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CountofSmallerNumbersAfterSelf {
    /*
        Count of Smaller Numbers After Self Binary Index Tree
        https://leetcode.com/problems/count-of-smaller-numbers-after-self/
        Difficulty: Hard
     */
    public class Solution {
        public int MAX = 11000; //we set max value that can be store in the tree
        int[] tree = new int[MAX];

        public List<Integer> countSmaller(int[] nums) {
            Integer[] result = new Integer[nums.length];

            //make all elements in the array posive while maintaining their order
            makePositive(nums);

            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] = get(nums[i]);
                add(nums[i] + 1, 1);
            }
            return Arrays.asList(result);
        }

        public void makePositive(int[] nums) {
            int min = MAX;
            for (int i = 0; i < nums.length; i++)
                min = Math.min(min, nums[i]);
            if (min < 0) {
                min = -min + 1;
                for (int i = 0; i < nums.length; i++)
                    nums[i] += min;
            }
        }

        public void add(int idx, int val) {
            while (idx < MAX) {
                tree[idx] += val;
                idx += (idx & (-idx));
            }
        }

        public int get(int idx) {
            int result = 0;
            while (idx > 0) {
                result += tree[idx];
                idx &= (idx - 1);
            }
            return result;
        }
    }

    /*
    Count of Smaller Numbers After Self Binary Tree
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/
    Difficulty: Hard
 */
    public class SolutionII {
        class Node {
            Node left, right;
            int val, sum, dup = 1;

            public Node(int v, int s) {
                val = v;
                sum = s;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            Integer[] ans = new Integer[nums.length];
            Node root = null;
            for (int i = nums.length - 1; i >= 0; i--) {
                root = insert(nums[i], root, ans, i, 0);
            }
            return Arrays.asList(ans);
        }

        private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
            if (node == null) {
                node = new Node(num, 0);
                ans[i] = preSum;
            } else if (node.val == num) {
                node.dup++;
                ans[i] = preSum + node.sum;
            } else if (node.val > num) {
                node.sum++;
                node.left = insert(num, node.left, ans, i, preSum);
            } else {
                node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
            }
            return node;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CountofSmallerNumbersAfterSelf().new Solution();
        }
    }
}
