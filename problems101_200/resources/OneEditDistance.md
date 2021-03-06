### Leetcode 161. One Edit Distance
[Leetcode Subscribed Problem](https://leetcode.com/problems/one-edit-distance/)

---

Given two strings *s* and *t* , determine if they are both one edit distance apart.

**Note:**

There are 3 possibilities to satisfy one edit distance apart:
1. Insert a character into *s* to get *t*
1. Delete a character from *s* to get *t*
1. Replace a character of *s* to get *t*


**Example 1:**
```
Input: _s_ = "ab", _t_ = "acb"
Output: true
Explanation: We can insert 'c' into _s_  to get  _t._
```

**Example 2:**
```
Input: _s_ = "cab", _t_ = "ad"
Output: false
Explanation: We cannot get _t_ from _s_ by only one step.
```

**Example 3:**
```
Input: _s_ = "1203", _t_ = "1213"
Output: true
Explanation: We can replace '0' with '1' to get  _t._
```
