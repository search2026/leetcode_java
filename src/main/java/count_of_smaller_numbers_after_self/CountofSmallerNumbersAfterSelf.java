package count_of_smaller_numbers_after_self;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class CountofSmallerNumbersAfterSelf {
    /*
        Count of Smaller Numbers After Self - Binary Search Tree
        https://leetcode.com/problems/count-of-smaller-numbers-after-self/
        Difficulty: Hard
     */
    public class Solution {
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<Integer>();
            if (nums == null || nums.length == 0) return res;
            TreeNode root = new TreeNode(nums[nums.length - 1]);
            res.add(0);
            for (int i = nums.length - 2; i >= 0; i--) {
                res.add(insert(root, nums[i]));
            }
            Collections.reverse(res);
            return res;
        }

        public int insert(TreeNode root, int num) {
            int thisCount = 0;
            while (true) {
                if (root.val >= num) {
                    root.count++;
                    if (root.left == null) {
                        root.left = new TreeNode(num);
                        break;
                    } else {
                        root = root.left;
                    }
                } else {
                    thisCount += root.count;
                    if (root.right == null) {
                        root.right = new TreeNode(num);
                        break;
                    } else {
                        root = root.right;
                    }
                }
            }
            return thisCount;
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            int count;

            public TreeNode(int value) {
                this.val = value;
                this.count = 1;
            }
        }
    }

    /*
        Count of Smaller Numbers After Self - Binary Index Tree/Fenwick Tree
        https://leetcode.com/problems/count-of-smaller-numbers-after-self/
        Difficulty: Hard
    */
    public class Solution_2 {
        private void add(int[] bit, int i, int val) {
            for (; i < bit.length; i += i & -i) bit[i] += val;
        }

        private int query(int[] bit, int i) {
            int ans = 0;
            for (; i > 0; i -= i & -i) ans += bit[i];
            return ans;
        }

        public List<Integer> countSmaller(int[] nums) {
            int[] tmp = nums.clone();
            Arrays.sort(tmp);
            for (int i = 0; i < nums.length; i++) nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
            int[] bit = new int[nums.length + 1];
            Integer[] ans = new Integer[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                ans[i] = query(bit, nums[i] - 1);
                add(bit, nums[i], 1);
            }
            return Arrays.asList(ans);
        }
    }

    /*
        Count of Smaller Numbers After Self - Segment Tree
        https://leetcode.com/problems/count-of-smaller-numbers-after-self/
        Difficulty: Hard
    */
    public class Solution_3 {
        public class segmentTreeNode {
            int start, end, count;
            segmentTreeNode left, right;

            segmentTreeNode(int start, int end, int count) {
                this.start = start;
                this.end = end;
                this.count = count;
                left = null;
                right = null;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> result = new ArrayList<Integer>();

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i : nums) {
                min = Math.min(min, i);

            }
            if (min < 0) {
                for (int i = 0; i < nums.length; i++) {
                    nums[i] -= min;//deal with negative numbers, seems a dummy way
                }
            }
            for (int i : nums) {
                max = Math.max(max, i);
            }
            segmentTreeNode root = build(0, max);
            for (int i = 0; i < nums.length; i++) {
                add(root, nums[i]);
            }
            for (int i = 0; i < nums.length; i++) {
                remove(root, nums[i]);
                result.add(query(root, 0, nums[i] - 1));
            }
            return result;
        }

        public segmentTreeNode build(int start, int end) {
            if (start > end) return null;
            if (start == end) return new segmentTreeNode(start, end, 0);
            int mid = (start + end) / 2;
            segmentTreeNode root = new segmentTreeNode(start, end, 0);
            root.left = build(start, mid);
            root.right = build(mid + 1, end);
            root.count = root.left.count + root.right.count;
            return root;
        }

        public int query(segmentTreeNode root, int start, int end) {
            if (root == null) return 0;
            if (root.start == start && root.end == end) return root.count;
            int mid = (root.start + root.end) / 2;
            if (end < mid) {
                return query(root.left, start, end);
            } else if (start > end) {
                return query(root.right, start, end);
            } else {
                return query(root.left, start, mid) + query(root.right, mid + 1, end);
            }
        }

        public void add(segmentTreeNode root, int val) {
            if (root == null || root.start > val || root.end < val) return;
            if (root.start == val && root.end == val) {
                root.count++;
                return;
            }
            int mid = (root.start + root.end) / 2;
            if (val <= mid) {
                add(root.left, val);
            } else {
                add(root.right, val);
            }
            root.count = root.left.count + root.right.count;
        }

        public void remove(segmentTreeNode root, int val) {
            if (root == null || root.start > val || root.end < val) return;
            if (root.start == val && root.end == val) {
                root.count--;
                return;
            }
            int mid = (root.start + root.end) / 2;
            if (val <= mid) {
                remove(root.left, val);
            } else {
                remove(root.right, val);
            }
            root.count = root.left.count + root.right.count;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new CountofSmallerNumbersAfterSelf().new Solution();
            assertTrue(true);
        }
    }
}
