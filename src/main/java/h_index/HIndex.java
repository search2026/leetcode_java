package h_index;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HIndex {
    /*
        H-Index
        https://leetcode.com/problems/h-index/
        Difficulty: Medium
    */
    public class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int[] countArray = new int[n + 1];

            for (int i = 0; i < n; i++) {
                if (citations[i] >= n) countArray[n]++;
                else countArray[citations[i]]++;
            }

            if (countArray[n] >= n) return n;

            for (int i = n - 1; i >= 0; i--) {
                countArray[i] = countArray[i] + countArray[i + 1];
                if (countArray[i] >= i) return i;
            }
            return 0;
        }
    }

    /*
        H-Index II
        https://leetcode.com/problems/h-index-ii/
        Difficulty: Medium
    */
    public class Solution_2 {
        public int hIndex(int[] citations) {
            int n = citations.length;

            int low = 0, high = n - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (citations[mid] == n - mid) return n - mid;
                else if (citations[mid] < n - mid) low = mid + 1;
                else high = mid - 1;
            }
            return n - low;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new HIndex().new Solution();
            assertEquals(3, 3);
        }
    }
}
