package com.search2026.leetcode.problems;

public class FallingSquares {

    /*
        Falling Squares - Intervals
        Leetcode #699
        https://leetcode.com/problems/falling-squares/
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
        https://leetcode.com/problems/falling-squares/
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

}
