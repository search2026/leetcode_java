package serialize_and_deserialize_binary_tree;

import common.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class SerializeandDeserializeBinaryTree {
    /*
        Serialize and Deserialize Binary Tree
        https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
        Difficulty: Medium
     */
    public class Codec {
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    sb.append(curr.val);
                    sb.append(" ");
                    queue.offer(curr.left);
                    queue.offer(curr.right);

                } else {
                    sb.append("#");
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.length() == 0) {
                return null;
            }

            data = data.trim();

            String delim = " ";
            String[] arr = data.split(delim);

            Queue<TreeNode> queue = new LinkedList<TreeNode>();

            TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    // Left child
                    TreeNode curr = queue.poll();
                    if (!arr[i].equals("#")) {
                        curr.left = new TreeNode(Integer.parseInt(arr[i]));
                        queue.offer(curr.left);
                    } else {
                        curr.left = null;
                    }

                    i++;
                    // Right child
                    if (!arr[i].equals("#")) {
                        curr.right = new TreeNode(Integer.parseInt(arr[i]));
                        queue.offer(curr.right);
                    } else {
                        curr.right = null;
                    }

                    i++;
                }
            }
            return root;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Codec sol = new SerializeandDeserializeBinaryTree().new Codec();
        }
    }
}
