package find_leaves_of_binary_tree;

import java.util.*;

import common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FindLeavesofBinaryTree {
  /*
      Find Leaves of Binary Tree
      Leetcode #366
      https://leetcode.com/discuss/questions/oj/find-leaves-of-binary-tree?sort=votes
      http://www.cnblogs.com/grandyang/p/5616158.html
      Difficulty: Medium
   */
  public class Solution {
    private List<List<Integer>> list = new ArrayList<>();

    private int search(TreeNode node){
      if (node == null) return -1;

      int level = Math.max(search(node.left), search(node.right)) + 1;

      if (list.size() == level) {
        list.add(new ArrayList<>());
      }

      list.get(level).add(node.val);

      return level;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
      search(root);
      return list;
    }
  }

  /*
    Find Leaves of Binary Tree - Modify Tree Nodes
    Leetcode #366
    https://leetcode.com/discuss/questions/oj/find-leaves-of-binary-tree?sort=votes
    http://www.cnblogs.com/grandyang/p/5616158.html
    Difficulty: Medium
 */
  public class Solution_2 {
    private TreeNode search(TreeNode node, List<Integer> currList) {
      if (node == null) return null;
      if (node.left == null && node.right == null) {
        currList.add(node.val);
        return null;
      }
      node.left = search(node.left, currList);
      node.right = search(node.right, currList);

      return node;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
      List<List<Integer>> list = new ArrayList<>();
      while (root != null) {
        List<Integer> currList = new ArrayList<>();
        root = search(root, currList);
        list.add(currList);
      }
      return list;
    }

  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new FindLeavesofBinaryTree().new Solution();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      List<List<Integer>> leaves = sol.findLeaves(root);
      assertEquals(3, leaves.size());
      assertEquals(3, leaves.get(0).size());
      assertEquals(4, (int)leaves.get(0).get(0));
      assertEquals(5, (int)leaves.get(0).get(1));
      assertEquals(3, (int)leaves.get(0).get(2));
      assertEquals(1, leaves.get(1).size());
      assertEquals(2, (int)leaves.get(1).get(0));
      assertEquals(1, leaves.get(2).size());
      assertEquals(1, (int)leaves.get(2).get(0));
    }

    @Test
    public void test2() {
      Solution_2 sol = new FindLeavesofBinaryTree().new Solution_2();
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(5);
      List<List<Integer>> leaves = sol.findLeaves(root);
      assertEquals(3, leaves.size());
      assertEquals(3, leaves.get(0).size());
      assertEquals(4, (int)leaves.get(0).get(0));
      assertEquals(5, (int)leaves.get(0).get(1));
      assertEquals(3, (int)leaves.get(0).get(2));
      assertEquals(1, leaves.get(1).size());
      assertEquals(2, (int)leaves.get(1).get(0));
      assertEquals(1, leaves.get(2).size());
      assertEquals(1, (int)leaves.get(2).get(0));
    }
  }
}

