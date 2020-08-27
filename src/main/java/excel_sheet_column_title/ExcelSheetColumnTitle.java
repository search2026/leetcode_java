package excel_sheet_column_title;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelSheetColumnTitle {
    /*
        Excel Sheet Column Title
        Leetcode #168
        https://leetcode.com/problems/excel-sheet-column-title/
        Difficulty: Easy
     */
    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder builder = new StringBuilder();
            while (n != 0) {
                n--;
                char c = (char) (n % 26 + 'A');
                builder.append(c);
                n /= 26;
            }
            return builder.reverse().toString();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new ExcelSheetColumnTitle().new Solution();
            assertTrue(true);
        }
    }
}

