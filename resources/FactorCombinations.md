### Leetcode 254. Factor Combinations
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/factor-combinations/)

---

Numbers can be regarded as product of its factors. For example,
```
8 = 2 x 2 x 2;
  = 2 x 4.
```
Write a function that takes an integer  n  and return all possible combinations of its factors.

<strong>Note:</strong>
<ol>
<li>You may assume that  n  is always positive.</li>
<li>Factors should be greater than 1 and less than  n.</li>
</ol>

<strong>Example 1:</strong>
```
Input: 1
Output: []
```
<strong>Example 2:</strong>
```
Input: 37
Output:[]
```
<strong>Example 3:</strong>
```
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
```
<strong>Example 4:</strong>
```
Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
```
