package merge_sorted_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeSortedArray {
  /*
      Merge Sorted Array
      Leetcode #88
      https://leetcode.com/problems/merge-sorted-array/
      Difficulty: Easy
   */
  public class Solution {
    public void merge(int nums1[], int m, int nums2[], int n) {
      if (nums1 == null || nums2 == null || m < 0 || n < 0) return;

      int i = m - 1, j = n - 1, k = n + m - 1;
      if (nums1.length < k) return;

      while (j >= 0) {
        nums1[k--] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
      }
    }
  }

  /*
      Merge Sorted Array
      Leetcode #88
      https://leetcode.com/problems/merge-sorted-array/
      Difficulty: Easy
   */
  public class Solution_2 {
    public void merge(int nums1[], int m, int nums2[], int n) {
      if (nums1 == null || nums2 == null || m < 0 || n < 0) return;
      int p1 = m - 1, p2 = n - 1, k = n + m - 1;
      for (int i = k; i >= 0 && p2 >= 0; i--) {
        if (p1 >= 0 && nums1[p1] > nums2[p2]) {
          nums1[i] = nums1[p1];
          p1--;
        } else {
          nums1[i] = nums2[p2];
          p2--;
        }
      }
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MergeSortedArray().new Solution();
      int[] array1 = {1, 3, 5, 0, 0, 0, 0};
      int[] array2 = {2, 4};
      sol.merge(array1, 3, array2, 2);
      assertEquals(1, array1[0]);
      assertEquals(2, array1[1]);
      assertEquals(3, array1[2]);
      assertEquals(4, array1[3]);
      assertEquals(5, array1[4]);
      assertEquals(0, array1[5]);
    }

    @Test
    public void test2() {
      Solution_2 sol = new MergeSortedArray().new Solution_2();
      int[] array1 = {1, 3, 5, 0, 0, 0, 0};
      int[] array2 = {2, 4};
      sol.merge(array1, 3, array2, 2);
      assertEquals(1, array1[0]);
      assertEquals(2, array1[1]);
      assertEquals(3, array1[2]);
      assertEquals(4, array1[3]);
      assertEquals(5, array1[4]);
      assertEquals(0, array1[5]);
    }
  }
}
