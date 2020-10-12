### Leetcode 251. Flatten 2D Vector
[Leetcode Subscribed Problem](https://leetcode.com/problems/flatten-2d-vector/)

---

Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =
```
[
  [1,2],
  [3],
  [4,5,6]
]
```


By calling *next* repeatedly until *hasNext*  returns false, the order of elements returned by *next* should be: `[1,2,3,4,5,6]`.

**Hint**:
1. How many variables do you need to keep track?
1. Two variables is all you need. Try with *x* and *y*.
1. Beware of empty rows. It could be the first few rows.
1. To write correct code, think about the invariant to maintain. What is it?
1. The invariant is *x* and *y* must always point to a valid point in the 2d vector. Should you maintain your invariant  ahead of *time* or *right* when you need it?
1. Not sure? Think about how you would implement *hasNext()*. Which is more complex?
1. Common logic in two different places should be refactored into a common method.

Follow up:
As an added challenge, try to code it using only [iterators in C++](http://www.cplusplus.com/reference/iterator/iterator/) or [iterators in Java](http://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html).
