package com.search2026.leetcode.problems;

import com.search2026.leetcode.common.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode {

    /*
        Populating Next Right Pointers in Each Node
        Leetcode #116
        https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
        Difficulty: Medium
     */
    public class Solution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode leftMost = root;
            while (leftMost != null) {
                TreeLinkNode p = leftMost;
                while (p.left != null) {
                    p.left.next = p.right;
                    if (p.next != null) {
                        p.right.next = p.next.left;
                        p = p.next;
                    } else {
                        break;
                    }
                }
                leftMost = leftMost.left;
            }
        }
    }

    /*
        Populating Next Right Pointers in Each Node II
        Leetcode #117
        https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
        Difficulty: Hard
     */
    public class Solution_2 {
        public void connect(TreeLinkNode root) {
            TreeLinkNode leftMost = root;
            while (leftMost != null) {
                TreeLinkNode p = leftMost;
                TreeLinkNode pre = null;
                leftMost = null;
                while (p != null) {
                    if (p.left != null) {
                        if (leftMost == null) {
                            leftMost = p.left;
                        }
                        if (pre != null) {
                            pre.next = p.left;
                        }
                        pre = p.left;
                    }
                    if (p.right != null) {
                        if (leftMost == null) {
                            leftMost = p.right;
                        }
                        if (pre != null) {
                            pre.next = p.right;
                        }
                        pre = p.right;
                    }
                    p = p.next;
                }
            }
        }
    }

}
