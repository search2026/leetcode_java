### Leetcode 716. Max Stack
[Leetcode Subscribed Problem](https://leetcode.com/problems/max-stack/)

---

Design a max stack that supports push, pop, top, peekMax and popMax.
1. push(x) -- Push element x onto stack.
1. pop() -- Remove the element on top of the stack and return it.
1. top() -- Get the element on the top.
1. peekMax() -- Retrieve the maximum element in the stack.
1. popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

**Example:**
```
MaxStack stack = new MaxStack();
stack.push(5); 
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
```
 
Note:
1. -1e7 <= x <= 1e7
1. Number of operations won't exceed 10000.
1. The last four operations won't be called when stack is empty.
