package first_bad_version;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FirstBadVersion {
    /*
        First Bad Version
        Leetcode #278
        https://leetcode.com/problems/first-bad-version/
        Difficulty: Easy
     */
    public class Solution {
        public int firstBadVersion(int n) {
            if (n <= 0) {
                return 0;
            }

            long lo = 1;
            long hi = n;

            while (lo + 1 < hi) {
                long mid = lo + (hi - lo) / 2;
                boolean bad = isBadVersion((int) mid);
                if (bad) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }

            if (isBadVersion((int) lo)) {
                return (int) lo;
            }

            if (isBadVersion((int) hi)) {
                return (int) hi;
            }

            return 0;
        }

        /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
        boolean isBadVersion(int version) {
            return true;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FirstBadVersion().new Solution();
            assertTrue(true);
        }
    }
}
