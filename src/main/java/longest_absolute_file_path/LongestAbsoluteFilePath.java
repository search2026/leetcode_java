package longest_absolute_file_path;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestAbsoluteFilePath {
  /*
      Longest Absolute File Path
      Leetcode #388
      https://leetcode.com/problems/longest-absolute-file-path/
      Difficulty: Medium
   */
  public class Solution {
    public int lengthLongestPath(String input) {
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(0); // "dummy" length
      int maxLen = 0;
      for(String s:input.split("\n")){
        int lev = s.lastIndexOf("\t")+1; // number of "\t"
        while(lev+1<stack.size()) stack.pop(); // find parent
        int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
        stack.push(len);
        // check if it is file
        if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
      }
      return maxLen;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new LongestAbsoluteFilePath().new Solution();
      assertEquals(20, sol.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\\n\t\tfile.ext"));
      assertEquals(32, sol.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
  }
}

