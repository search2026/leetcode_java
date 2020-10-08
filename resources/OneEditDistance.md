### Leetcode 161. One Edit Distance
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/one-edit-distance/)

---

Given two strings <em>s</em> and <em>t</em> , determine if they are both one edit distance apart.

<strong>Note:</strong>

There are 3 possibilities to satisfy one edit distance apart:
<ol>
<li>Insert a character into <em>s</em> to get <em>t</em></li>
<li>Delete a character from <em>s</em> to get <em>t</em></li>
<li>Replace a character of <em>s</em> to get <em>t</em></li>
</ol>

<strong>Example 1:</strong>
```
Input: _s_ = "ab", _t_ = "acb"
Output: true
Explanation: We can insert 'c' into _s_  to get  _t._
```
<strong>Example 2:</strong>
```
Input: _s_ = "cab", _t_ = "ad"
Output: false
Explanation: We cannot get _t_ from _s_ by only one step.
```
<strong>Example 3:</strong>
```
Input: _s_ = "1203", _t_ = "1213"
Output: true
Explanation: We can replace '0' with '1' to get  _t._
```
