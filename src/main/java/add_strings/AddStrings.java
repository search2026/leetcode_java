package add_strings;

import java.util.*;
import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddStrings {
    /*
        Add Strings
        Leetcode #415
        https://leetcode.com/problems/add-strings/description/
        Difficulty: Easy
     */
    public class Solution {
        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
                int x = i < 0 ? 0 : num1.charAt(i) - '0';
                int y = j < 0 ? 0 : num2.charAt(j) - '0';
                sb.append((x + y + carry) % 10);
                carry = (x + y + carry) / 10;
            }
            return sb.reverse().toString();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new AddStrings().new Solution();
            assertEquals("504", sol.addStrings("415", "89"));
            assertEquals("504", sol.addStrings("89", "415"));
        }
    }
}

