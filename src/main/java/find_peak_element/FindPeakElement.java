package find_peak_element;

import java.util.*;

import org.junit.*;

import static org.junit.Assert.*;

public class FindPeakElement {
    /*
        Find Peak Element
        https://leetcode.com/problems/find-peak-element/
        Difficulty: Medium
     */
    public class Solution {
        public int findPeakElement(int[] nums) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    return i;
                }
            }
            return nums.length - 1;
        }

        public int findPeakElementBinarySearch(int[] nums) {
            if (nums==null) return -1;
            if (nums.length==1) return 0;
            int l = 0, r = nums.length-1;
            while (l<=r) {
                int mid = (l+r)/2;
                if ( mid==0 ) {
                    if ( nums[mid]>nums[mid+1] ) return mid;
                    else l = mid+1;
                }
                else if ( mid==nums.length-1 ) {
                    if ( nums[mid]>nums[mid-1] ) return mid;
                    else r = mid-1;
                }
                else if ( nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1] ) {
                    return mid;
                }
                else if ( nums[mid]<=nums[mid-1]) {
                    r = mid -1;
                }
                else { // num[mid]<=num[mid+1]
                    l = mid + 1;
                }
            }
            return -1;
        }

    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new FindPeakElement().new Solution();
            assertTrue(true);
        }
    }
}

