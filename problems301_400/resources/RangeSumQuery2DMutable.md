### Leetcode 308. Range Sum Query 2D - Mutable
[Leetcode Subscribed Problem](https://leetcode.com/problems/range-sum-query-2d-mutable/)

---

Given a 2D matrix matrix , find the sum of the elements inside the rectangle defined by its upper left corner (*row*1, *col*1) and lower right corner (*row*2, *col*2).

![](RangeSumQuery2DMutable_001.png?raw=true")

The above rectangle (with the red border) is defined by (*row*1, *col*1) = **(2, 1)** and (*row*2, *col*2) = **(4, 3)**, which contains sum = **8**.

Example:
```
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
```

**Note:**
1. The matrix is only modifiable by the update function.
1. You may assume the number of calls to update and sumRegion function is distributed evenly.
1. You may assume that row 1 ≤ *row*2 and col 1 ≤ *col*2.
