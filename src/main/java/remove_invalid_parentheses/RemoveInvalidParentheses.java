package remove_invalid_parentheses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class RemoveInvalidParentheses {
    /*
        Remove Invalid Parentheses
        https://leetcode.com/problems/remove-invalid-parentheses/
        Difficulty: Hard
     */
    public class Solution {
        public List<String> removeInvalidParentheses(String s) {
            List<String> list = new ArrayList<String>();
            Set<String> set = new HashSet<String>();
            set.add(s);

            while (list.isEmpty()) {
                Set<String> newSet = new HashSet<String>();
                for (String ss : set) {
                    if (isValid(ss)) {
                        list.add(ss);
                        continue;
                    }

                    newSet.addAll(removeOneLetter(ss));
                }

                set = newSet;
            }

            return list;
        }

        private boolean isValid(String s) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(')
                    count++;
                else if (ch == ')')
                    count--;

                if (count < 0)
                    return false;
            }

            return count == 0;
        }

        private Set<String> removeOneLetter(String s) {
            Set<String> set = new HashSet<String>();
            if (s.length() == 1) {
                set.add("");
                return set;
            }

            for (int i = 0; i < s.length(); i++)
                set.add(s.substring(0, i) + s.substring(i + 1));

            return set;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new RemoveInvalidParentheses().new Solution();
            assertEquals(7, 7);
        }
    }
}
