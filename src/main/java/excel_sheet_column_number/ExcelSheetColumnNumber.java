package excel_sheet_column_number;

public class ExcelSheetColumnNumber {

    public class Solution {
        public int titleToNumber(String s) {
            int n = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                n = n * 26 + c - 'A' + 1;
            }
            return n;
        }
    }

    public static class UnitTest {

    }
}

