package falling_squares;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class FallingSquares {
    /*
        Falling Squares - Intervals
        Leetcode #699
        https://leetcode.com/problems/falling-squares/description/
        Difficulty: Hard
     */
    public class Solution {
        private class Interval {
            int start, end, height;

            public Interval(int start, int end, int height) {
                this.start = start;
                this.end = end;
                this.height = height;
            }
        }

        private int getHeight(List<Interval> intervals, Interval cur) {
            int preMaxHeight = 0;
            for (Interval i : intervals) {
                if (i.end < cur.start) continue;
                if (i.start > cur.end) continue;
                preMaxHeight = Math.max(preMaxHeight, i.height);
            }
            cur.height += preMaxHeight;
            intervals.add(cur);
            return cur.height;
        }

        public List<Integer> fallingSquares(int[][] positions) {
            List<Interval> intervals = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            int h = 0;
            for (int[] pos : positions) {
                Interval cur = new Interval(pos[0], pos[0] + pos[1] - 1, pos[1]);
                h = Math.max(h, getHeight(intervals, cur));
                res.add(h);
            }
            return res;
        }
    }

    /*
        Falling Squares - Segment Tree
        Leetcode #699
        https://leetcode.com/problems/falling-squares/description/
        Difficulty: Hard
     */
    public class Solution_2 {
        class SegNode {
            int left, mid, right;
            int max;
            boolean modified;
            SegNode leftChild, rightChild;

            SegNode(int left, int right, int max) {
                this.left = left;
                this.right = right;
                this.mid = left + (right - left) / 2;
                this.max = max;
            }

            int query(int left, int right) {
                int ans;
                if ((left <= this.left && right >= this.right) || this.leftChild == null) {
                    ans = this.max;
                } else {
                    pushdown();
                    ans = Integer.MIN_VALUE;
                    if (left <= this.mid && this.leftChild != null)
                        ans = Math.max(ans, leftChild.query(left, Math.min(this.mid, right)));
                    if (right > this.mid && this.rightChild != null)
                        ans = Math.max(ans, rightChild.query(Math.max(this.mid + 1, left), right));
                }
                return ans;
            }

            void pushdown() {
                if (this.leftChild != null) {
                    if (this.modified) {
                        this.leftChild.modified = true;
                        this.leftChild.max = max;
                        this.rightChild.modified = true;
                        this.rightChild.max = max;
                    }
                } else {
                    this.leftChild = new SegNode(left, mid, max);
                    this.rightChild = new SegNode(mid + 1, right, max);

                }
            }

            void insert(int left, int right, int value) {
                if (left <= this.left && right >= this.right) {
                    if (value > this.max) {
                        this.max = Math.max(this.max, value);
                        modified = true;
                    }

                } else {
                    pushdown();
                    if (left <= mid) this.leftChild.insert(left, Math.min(mid, right), value);
                    if (right > mid) this.rightChild.insert(Math.max(mid + 1, left), right, value);
                    this.max = Math.max(this.leftChild.max, this.rightChild.max);
                    modified = false;
                }
            }
        }

        public List<Integer> fallingSquares(int[][] positions) {
            List<Integer> res = new ArrayList<>();
            int left = 0, right = 1_000_000_000;
            if (positions.length == 0) return res;
            SegNode root = new SegNode(left, right, 0);
            int oldPeek = 0;
            for (int[] rec : positions) {
                int curMax = root.query(rec[0], rec[0] + rec[1] - 1);
                int newMax = curMax + rec[1];
                oldPeek = Math.max(oldPeek, newMax);
                res.add(oldPeek);
                root.insert(rec[0], rec[0] + rec[1] - 1, newMax);
            }
            return res;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FallingSquares().new Solution();
            int[][] test1 = {
                    {1, 2},
                    {2, 3},
                    {6, 1}
            };
            List<Integer> res = sol.fallingSquares(test1);
            assertEquals(3, res.size());
            assertEquals(2, (int) res.get(0));
            assertEquals(5, (int) res.get(1));
            assertEquals(5, (int) res.get(2));

            int[][] test2 = {
                    {100, 100},
                    {200, 100}
            };
            res = sol.fallingSquares(test2);
            assertEquals(2, res.size());
            assertEquals(100, (int) res.get(0));
            assertEquals(100, (int) res.get(1));
        }

        @Test
        public void test2() {
            Solution_2 sol = new FallingSquares().new Solution_2();
            int[][] test1 = {
                    {1, 2},
                    {2, 3},
                    {6, 1}
            };
            List<Integer> res = sol.fallingSquares(test1);
            assertEquals(3, res.size());
            assertEquals(2, (int) res.get(0));
            assertEquals(5, (int) res.get(1));
            assertEquals(5, (int) res.get(2));

            int[][] test2 = {
                    {100, 100},
                    {200, 100}
            };
            res = sol.fallingSquares(test2);
            assertEquals(2, res.size());
            assertEquals(100, (int) res.get(0));
            assertEquals(100, (int) res.get(1));
        }
    }
}

