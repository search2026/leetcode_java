### LeetCode 286. Walls and Gates
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/walls-and-gates/)

---

You are given a m x n 2D grid initialized with these three possible values.
<ol>
<li><code>-1</code> - A wall or an obstacle.</li>
<li><code>0</code> - A gate.</li>
<li><code>INF</code> - Infinity means an empty room. We use the value <code>2 31 - 1 = 2147483647</code> to represent <code>INF</code> as you may assume that the distance to a gate is less than <code>2147483647</code>.</li>
</ol>
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.


<strong>Example:<strong>

```
given the 2D grid

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF

After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
```
