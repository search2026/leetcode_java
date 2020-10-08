### Leetcode 265. Paint House II
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/paint-house-ii/)

---

There are a row of <em>n</em> houses, each house can be painted with one of the <em>k</em> colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a  `_n_  x  _k_` cost matrix. For example, `costs[0][0]` is the cost of painting house 0 with color 0; `costs[1][2]` is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

<strong>Note:</strong>
All costs are positive integers.

<strong>Example:</strong>
```
Input: [[1,5,3],[2,9,4]]
Output: 5
Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
             Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
```

<strong>Follow up:</strong>
Could you solve it in <em>O(nk)</em> runtime?

