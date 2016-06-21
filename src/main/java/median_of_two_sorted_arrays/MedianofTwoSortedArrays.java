package median_of_two_sorted_arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MedianofTwoSortedArrays {
  /*
      Median of Two Sorted Arrays - Recursion
      Leetcode #4
      https://leetcode.com/problems/median-of-two-sorted-arrays/
      Difficulty: Hard
   */
  public class Solution {
    private int findKth(int A[], int m, int B[], int n, int k) {
      if (m == 0) return B[k - 1];
      if (n == 0) return A[k - 1];
      if (m + n == k) return Math.max(A[m - 1], B[n - 1]);
      if (m > n) return findKth(B, n, A, m, k);

      int x = Math.min(m, k / 2 + 1);
      int y = k + 1 - x;
      if (A[x - 1] < B[y - 1]) {
        return findKth(A, m, B, y - 1, k);
      } else if (A[x - 1] > B[y - 1]) {
        return findKth(A, x - 1, B, n, k);
      } else {
        return A[x - 1];
      }
    }

    public double findMedianSortedArrays(int nums1[], int nums2[]) {
      int n = nums1.length + nums2.length;
      if (n % 2 == 1) {
        return findKth(nums1, nums1.length, nums2, nums2.length, n / 2 + 1);
      }
      return (findKth(nums1, nums1.length, nums2, nums2.length, n / 2) +
              findKth(nums1, nums1.length, nums2, nums2.length, n / 2 + 1)) / 2.0;
    }
  }

  /*
      Median of Two Sorted Arrays - Iterative
      Leetcode #4
      https://leetcode.com/problems/median-of-two-sorted-arrays/
      Difficulty: Hard
   */
  public class Solution_2 {
    public double findMedianSortedArrays(int nums1[], int nums2[]) {
      int n = nums1.length;
      int m = nums2.length;
      if (n > m) return findMedianSortedArrays(nums2, nums1);

      // now, do binary search
      int mid = (n + m - 1) / 2;
      int left = 0, right = Math.min(mid, n); // r is n, NOT n-1, this is important!!
      while (left < right) {
        int midA = (left + right) / 2;
        int midB = mid - midA;
        if (nums1[midA] < nums2[midB])
          left = midA + 1;
        else
          right = midA;
      }

      // after binary search, we almost get the median because it must be between
      // these 4 numbers: A[left-1], A[left], B[mid-l], and B[mid-left+1]

      // if (n+m) is odd, the median is the larger one between A[left-1] and B[mid-l].
      // and there are some corner cases we need to take care of.
      int a = Math.max(left > 0 ? nums1[left - 1] : Integer.MIN_VALUE, mid - left >= 0 ? nums2[mid - left] : Integer.MIN_VALUE);
      if (((n + m) & 1) == 1)
        return (double) a;

      // if (n+m) is even, the median can be calculated by
      //      median = (max(A[left-1], B[mid-l]) + min(A[left], B[mid-left+1]) / 2.0
      // also, there are some corner cases to take care of.
      int b = Math.min(left < n ? nums1[left] : Integer.MAX_VALUE, mid - left + 1 < m ? nums2[mid - left + 1] : Integer.MAX_VALUE);
      return (a + b) / 2.0;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution s = new MedianofTwoSortedArrays().new Solution();
      double expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2});
      assertEquals(2.5, expected, 1E-5);
      expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2, 5});
      assertEquals(3.0, expected, 1E-5);
    }

    @Test
    public void test2() {
      Solution_2 s = new MedianofTwoSortedArrays().new Solution_2();
      double expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2});
      assertEquals(2.5, expected, 1E-5);
      expected = s.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2, 5});
      assertEquals(3.0, expected, 1E-5);
    }
  }
}
