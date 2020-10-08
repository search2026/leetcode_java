### Leetcode 158. Read N Characters Given Read4 II - Call multiple times
Subscribed Problem
[Leetcode link](https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/)

---

Given a file and assume that you can only read the file using a given method `read4`, implement a method `read` to read <em>n</em> characters. Your method `read` may be called multiple times.


<strong>Method read4:</strong>

The API `read4` reads 4 consecutive characters from the file, then writes those characters into the buffer array `buf`.

The return value is the number of actual characters read.

Note that `read4()` has its own file pointer, much like `FILE *fp` in C.
```
Definition of read4:

    Parameter:  char[] buf
    Returns:    int

Note: buf[] is destination not source, the results from read4 will be copied to buf[]
```
Below is a high level example of how `read4` works:
```
File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file
```


<strong>Method read:</strong>

By using the `read4` method, implement the method `read` that reads <em>n</em> characters from the file and store it in the buffer array `buf`. Consider that you cannot manipulate the file directly.

The return value is the number of actual characters read.
```
Definition of read:

    Parameters:	char[] buf, int n
    Returns:	int

Note: buf[] is destination not source, you will need to write the results to buf[]
```

<strong>Example 1:</strong>
```
File file("abc");
Solution sol;
// Assume buf is allocated and guaranteed to have enough space for storing all characters from the file.
sol.read(buf, 1); // After calling your read method, buf should contain "a". We read a total of 1 character from the file, so return 1.
sol.read(buf, 2); // Now buf should contain "bc". We read a total of 2 characters from the file, so return 2.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
```
<strong>Example 2:</strong>
```
File file("abc");
Solution sol;
sol.read(buf, 4); // After calling your read method, buf should contain "abc". We read a total of 3 characters from the file, so return 3.
sol.read(buf, 1); // We have reached the end of file, no more characters can be read. So return 0.
```

<strong>Note:</strong>
<ol>
<li>Consider that you cannot manipulate the file directly, the file is only accessible for <code>read4</code> but not for <code>read</code>.</li>
<li>The <code>read</code> function may be called multiple times.</li>
<li>Please remember to RESET your class variables declared in Solution, as static/class variables are persisted across multiple test cases. Please see [here](https://leetcode.com/faq/) for more details.</li>
<li>You may assume the destination buffer array, <code>buf</code>, is guaranteed to have enough space for storing <em>n</em> characters.</li>
<li>It is guaranteed that in a given test case the same buffer <code>buf</code> is called by <code>read</code>.</li>
</ol>
