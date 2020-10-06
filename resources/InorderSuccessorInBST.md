### Leetcode 285. Inorder Successor in BST
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/inorder-successor-in-bst/)

---

Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

The successor of a node p is the node with the smallest key greater than `p.val`.

<strong>Example 1:</strong>
![](../resources/InorderSuccessorInBST_001.png?raw=true")
```
Input: root = [2,1,3], p = 1
Output: 2
Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
```

<strong>Example 2:</strong>
![](../resources/InorderSuccessorInBST_002.png?raw=true")
```
Input: root = [5,3,6,2,4,null,null,1], p = 6
Output: null
Explanation: There is no in-order successor of the current node, so the answer is null.
```

<strong>Note:</strong>
<ol>
<li>If the given node has no in-order successor in the tree, return null.</li>
<li>It's guaranteed that the values of the tree are unique.</li>
</ol>
